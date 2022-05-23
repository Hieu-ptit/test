package com.admin_management.model.bo;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class MessageExcels {

    public static final String TITLE = "Danh_sách_đánh_giá_nhân_viên_" + LocalDate.now() + ".xlsx";

    public static final String TIME_DISPLAY = "          Từ ngày %s - Đến ngày %s";

    public static final String EMPLOYEE_INFO = " %s_%s_%s";

    public static final List<String> FIELD_EVALUATION = Arrays.asList("code", "name", "fiveStar", "fourStar", "threeStar",
            "twoStar", "oneStar", "voteMedium", "pointEvaluation");

}
