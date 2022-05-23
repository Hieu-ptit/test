package com.common.util;

import com.fasterxml.uuid.Generators;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.format.DateTimeFormatter;

public final class Constant {

    public static final DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static final String ROLE_PREFIX = "ROLE_";
    public static final String PREFIX_RESPONSE_CODE = "SUN-OIL-";
    public static final String GUEST_PHONE_NUMBER = "+999999999";
    public static final String GUEST_PASSWORD = "AnonymousAccount";
    public static final String GUEST_ID = "guest";
    public static final long ANONYMOUS_USER_ID = -1;
    public static final String GUEST_ROLE = "ROLE_GUEST";
    public static final String USER_ROLE = "ROLE_USER";
    public static final String SERVICE_CHANNEL_CODE = "MAIN";

    public static final String BEARER = "Bearer";
    public static final String USER_ATTR = "user";
    public static final String SEPARATOR = "-";
    public static final String UNDERLINE = "_";

    public static final String JWT_OA = "JWT_OA";
    public static final String TOKEN = "token";
    public static final String  OTP_PRE = "OTP_";
    public static final String SS_FIRST_TIMES = "USER_LOGIN_FIRST_TIMES_";
    public static final String ACCOUNT_ID = "account_id";
    public static final String USERNAME = "username";


    public static final Logger logger;

    public static final String X_USER = "X-User";
    public static final String ROLE = "role";
    public static final String BIT_SET = "bit_set";
    public static final String ACTION = "action";

    static {
        logger = LogManager.getLogger(Constant.class);
    }

    private Constant() {
        //hidden constructor
    }

    public static String generateUUID() {
        return Generators.randomBasedGenerator().generate().toString();
    }

    public static boolean compareEnum(Object... o) {

        for (int i = 0; i < o.length - 1; i++)
            if (!o[i].toString().equals(o[i + 1].toString())) return false;

        return true;
    }


}
