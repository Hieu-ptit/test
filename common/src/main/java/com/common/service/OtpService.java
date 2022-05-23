package com.common.service;

import org.springframework.stereotype.Service;

@Service
public interface OtpService {

    /**
     * Generate OTP and expire this OTP into Redis
     *
     * @param len length of otp
     * @param expireTime  expire time of OTP (seconds)
     * @param value value for saving to buffer (exp: phone number, ...)
     *
     * @return the otp
     */
    String generateNSaveOtp(Integer len, Long expireTime, String value);

    /**
     * Generate OTP by length. If @param len is null, default len = @lenDefaultOtp will be used.
     *
     * @param len length of otp
     * @return the otp
     */
    String generateOtp(Integer len);

    /**
     * Get value by Key OTP
     *
     * @param otp
     * @return
     */
    String getByOtp(String otp);

    /**
     * Verify OTP
     *
     * @param otp
     * @return
     */
    boolean verifyOtp(String otp);

    /**
     * Revoke OTP
     *
     * @param otp
     * @return
     */
    boolean revokeOtp(String otp);

    /**
     * Verify OTP, after revoke token
     *
     * @param otp
     * @return
     */
    boolean verifyNRevokeOtp(String otp);

    boolean revokeLoginSession(String id);

}
