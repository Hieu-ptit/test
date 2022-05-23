package com.auth_management.security;

import com.common.util.Constant;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.params.SetParams;

@Service
@RequiredArgsConstructor
public class BOSessionManager {

    @Value("${app.session.changer.password.first.times}")
    private Long expireTimeChangePasswordTimes;

    private final JedisPool jedisPool;

    /**
     * Save the user's username if this user logs in for the first time
     *
     * @param sessionCode
     * @return
     */
    public boolean verifySessionCode(String sessionCode, String type) {
        try (Jedis jedis = jedisPool.getResource()) {
            return jedis.exists(type + sessionCode);
        }
    }

    /**
     * Save the user's username if this user logs in for the first time
     *
     * @param id
     * @param expireTime expireTime of username in buffer (redis, ...), seconds
     *
     * @return
     */
    public boolean saveSessionLoginFirstTime(String id, Long expireTime) {
        try (Jedis jedis = jedisPool.getResource()) {
            expireTime = expireTime == null ? expireTimeChangePasswordTimes : expireTime;
            String key = Constant.SS_FIRST_TIMES + id;
            String saveSuccess = jedis.set(key, "1", SetParams.setParams().ex(expireTime));
            return !StringUtils.isEmpty(saveSuccess);
        }
    }

    /**
     * Revoke session code
     *
     * @param id
     * @return
     */
    public boolean revokeSessionLoginFirstTime(String id) {
        try (Jedis jedis = jedisPool.getResource()) {
            String key = Constant.SS_FIRST_TIMES + id;
            return jedis.del(key) > 0;
        }
    }

}
