package com.admin_management.util;

import com.common.util.Constant;

public class BusinessAccountUtil {

    public BusinessAccountUtil() {
    }

    public static boolean isAnonymousId(long id) {
        return id == Constant.ANONYMOUS_USER_ID;
    }

}
