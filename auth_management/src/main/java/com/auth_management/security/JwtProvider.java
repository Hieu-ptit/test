package com.auth_management.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth_management.caller.PermissionCaller;
import com.auth_management.model.request.RoleClaim;
import com.auth_management.model.response.AccountAuth;
import com.auth_management.model.response.RoleResponse;
import com.auth_management.model.response.RoleResponseDetail;
import com.common.exception.BusinessException;
import com.common.model.AccountClaim;
import com.common.model.response.Response;
import com.common.util.Constant;
import com.common.util.ErrorCode;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

@Component
@Log4j2
public class JwtProvider {

    private final Logger logger = LogManager.getLogger(getClass());

    private final Algorithm algorithm;
    private final JWTVerifier jwtVerifier;
    private final JedisPool jedisPool;
    private final LoginSessionManager loginSessionManager;
    private final PermissionCaller permissionCaller;

    @Autowired
    public JwtProvider(@Value("${app.jwt.secret.account}") String secretJwt,
                       JedisPool jedisPool,
                       LoginSessionManager loginSessionManager,
                       PermissionCaller permissionCaller) {
        this.algorithm = Algorithm.HMAC256(secretJwt);
        this.jwtVerifier = JWT.require(this.algorithm).build();
        this.jedisPool = jedisPool;
        this.loginSessionManager = loginSessionManager;
        this.permissionCaller = permissionCaller;
    }

    public DecodedJWT validateJWT(HttpServletRequest request) {
        String token = getJWTToken(request);
        return StringUtils.isEmpty(token) ? null : validateJWT(token);
    }

    /**
     * Validate JWT
     *
     * @param token
     * @return
     */
    public DecodedJWT validateJWT(String token) {
        try (Jedis jedis = jedisPool.getResource()) {
            DecodedJWT decodedJWT = this.jwtVerifier.verify(token);
            String tokenSession = jedis.get(loginSessionManager.toKey(decodedJWT.getClaim(Constant.ACCOUNT_ID).asString()));
            return token.equals(tokenSession) ? decodedJWT : null;
        }
    }



    /**
     * @param request
     * @return
     */
    public AccountClaim getAccountClaim(HttpServletRequest request) {
        DecodedJWT decodedJWT;
        try {
            decodedJWT = (DecodedJWT) request.getAttribute(Constant.USER_ATTR);
            if (decodedJWT == null) return null;
        } catch (Exception e) {
            logger.error(e);
            return null;
        }

        AccountClaim accountClaim = new AccountClaim();
        accountClaim.setAccountId(decodedJWT.getClaim(Constant.ACCOUNT_ID).asString());
        accountClaim.setUsername(decodedJWT.getClaim(Constant.USERNAME).asString());
        accountClaim.setRole(decodedJWT.getClaim(Constant.ROLE).asString());
        accountClaim.setBitSet(decodedJWT.getClaim(Constant.BIT_SET).asString());

        return accountClaim;
    }

    /**
     * Generate JWT
     * if timeExpire is null, default expireTime will be used
     *
     * @param timeExpire
     * @param accountAuth
     * @return
     */
    public String generateJWT(AccountAuth accountAuth, Long timeExpire) {

        // TODO : Get role and bitset
        Response<RoleResponseDetail> roles = permissionCaller.getRoles(accountAuth.getAccountId()).join();
        if (roles.getData() == null)
            throw new BusinessException(ErrorCode.UNAUTHORIZED, ErrorCode.UNAUTHORIZED.getMessage());

        RoleClaim roleClaim = getRoleClaim(roles.getData());

        String token = JWT.create()
                .withIssuedAt(Date.from(Instant.now()))
                .withClaim(Constant.ACCOUNT_ID, accountAuth.getAccountId())
                .withClaim(Constant.USERNAME, accountAuth.getUsername())
                .withClaim(Constant.ROLE, roleClaim.getRole())
                .withClaim(Constant.BIT_SET, roleClaim.getBitSet())
                .sign(this.algorithm);

        // save token to buffer
        loginSessionManager.saveLoginSession(accountAuth.getAccountId(), token, timeExpire);
        return token;
    }

    /**
     * Find Token in buffer (Redis, Aerospike, ...), if don't have then generate a new token
     * if timeExpire is null, default expireTime will be used
     *
     * @param accountAuth
     * @param timeExpire
     * @return
     */
    public String findOrGenerateJwt(AccountAuth accountAuth, Long timeExpire) {
        String token = loginSessionManager.findToken(accountAuth.getAccountId());
        return StringUtils.isEmpty(token) ? generateJWT(accountAuth, timeExpire) : token;
    }

    /**
     * Get JWT in request
     * @param request
     * @return
     */
    public String getJWTToken(HttpServletRequest request) {
        String authorizationVal = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (authorizationVal == null
                || authorizationVal.length() <= Constant.BEARER.length() + 1
                || !authorizationVal.startsWith(Constant.BEARER))
            return "";

        return authorizationVal.substring(Constant.BEARER.length() + 1);
    }


    private RoleClaim getRoleClaim(RoleResponseDetail roleResponseDetail) {
        List<RoleResponse> roleResponses = roleResponseDetail.getRoleResponses();

        Set<Integer> roleIds = roleResponses.stream().map(RoleResponse::getId).collect(Collectors.toSet());

        Map<Integer, Map<String, Integer>> bitSetSummary = roleResponses
                .stream()
                .collect(Collectors.toMap(RoleResponse::getId, RoleResponse::getBitSetModule));

        return RoleClaim.build()
                .setRole(roleIds)
                .setBitSet(bitSetSummary);
    }

}
