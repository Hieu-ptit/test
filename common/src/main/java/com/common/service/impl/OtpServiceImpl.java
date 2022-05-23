package com.common.service.impl;

import com.common.service.OtpService;
import com.common.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.params.SetParams;

import java.security.SecureRandom;

@Service
public class OtpServiceImpl implements OtpService {

    private final JedisPool jedisPool;
    private final Integer lenDefaultOtp;
    private final Long defaultExpireTime;


    @Autowired
    public OtpServiceImpl(@Value("${app.otp.length}") Integer lenDefaultOtp,
                          @Value("${app.otp.expire.default}") Long defaultExpireTime,
                          JedisPool jedisPool) {
        this.jedisPool = jedisPool;
        this.lenDefaultOtp = lenDefaultOtp;
        this.defaultExpireTime = defaultExpireTime;
    }

    /**
     * Generate OTP and expire this OTP into Redis
     *
     * @param len length of otp
     * @param expireTime  expire time of OTP (seconds)
     * @param value value for saving to buffer (exp: phone number, ...)
     *
     * @return the otp
     */
    @Override
    public String generateNSaveOtp(Integer len, Long expireTime, String value) {
        String otp = this.generateOtp(lenDefaultOtp);
        try (Jedis jedis = jedisPool.getResource()) {

            String key = toKeyOtp(otp);
            if (jedis.exists(key)) generateNSaveOtp(len, expireTime, value);

            expireTime = expireTime == null ? defaultExpireTime : expireTime;
            jedis.set(key, value, SetParams.setParams().ex(expireTime));
            return otp;
        }
    }

    /**
     * Generate OTP by length. If @param len is null, default len = @lenDefaultOtp will be used.
     *
     * @param len length of otp
     * @return the otp
     */
    public String generateOtp(Integer len) {
        if (len == null || len <= 0) len = lenDefaultOtp;
        StringBuilder otp = new StringBuilder();
        SecureRandom random = new SecureRandom();
        for (int i = 0; i < len; i++)
            otp.append(random.nextInt(9));

        return otp.toString();
    }

    /**
     * Get value by Key OTP
     *
     * @param otp
     * @return
     */
    @Override
    public String getByOtp(String otp) {
        try (Jedis jedis = jedisPool.getResource()) {
            return jedis.get(toKeyOtp(otp));
        }
    }

    /**
     * Verify OTP
     *
     * @param otp
     * @return
     */
    @Override
    public boolean verifyOtp(String otp) {
        try (Jedis jedis = jedisPool.getResource()) {
            return jedis.exists(toKeyOtp(otp));
        }
    }

    /**
     * Revoke OTP
     *
     * @param otp
     * @return
     */
    @Override
    public boolean revokeOtp(String otp) {
        try (Jedis jedis = jedisPool.getResource()) {
            return jedis.del(toKeyOtp(otp)) > 0;
        }
    }

    /**
     * Verify OTP, after revoke token
     *
     * @param otp
     * @return
     */
    @Override
    public boolean verifyNRevokeOtp(String otp) {
        return verifyOtp(otp) && revokeOtp(otp);
    }

    /**
     * Create Key for saving OTP into Redis
     *
     * @param otp
     * @return
     */
    private String toKeyOtp(String otp) {
        return Constant.OTP_PRE + otp;
    }

    /**
     * revoke token delete employee
     *
     * @param id
     * @return
     */
    @Override
    public boolean revokeLoginSession(String id) {
        try (Jedis jedis = jedisPool.getResource()) {
            return jedis.del(toKey(id)) > 0;
        }
    }
    public String toKey(String id) {
        return id + Constant.SEPARATOR + Constant.JWT_OA;
    }

}
