package com.admin_management.util.filter;

import com.common.exception.BusinessException;
import com.common.util.ErrorCode;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Collectors;


public final class FilterBuilderUtil {
    private static final Logger logger = LogManager.getLogger(FilterBuilderUtil.class);
    private static final String FILTER_SEARCH_DELIMITER = "&";
    private static final String FILTER_CONDITION_DELIMITER = "\\|";
    private static final String LIST_DELIMITER = ",";

    private FilterBuilderUtil() {
    }

    public static List<SearchCriteria> createFilterCondition(String criteria, Map<String, BiFunction<String, String, ?>> typeConverters) {
        if (StringUtils.isEmpty(criteria))
            return Collections.emptyList();

        List<String> expressions = splitStringToList(criteria, FILTER_SEARCH_DELIMITER);
        if (expressions.isEmpty())
            return Collections.emptyList();

        return expressions.stream().map(expression -> splitStringToList(expression, FILTER_CONDITION_DELIMITER))
                .map(expression -> getCriteria(typeConverters, expression))
                .collect(Collectors.toList());
    }


    private static SearchCriteria getCriteria(Map<String, BiFunction<String, String, ?>> typeConverters, List<String> expressionSeeds) {
        try {
            logger.info("Start getting criteria in {}", expressionSeeds);
            var stringOperator = expressionSeeds.get(1);
            var operator = SearchOperator.fromValue(stringOperator);
            var stringValue = expressionSeeds.get(2);
            var field = expressionSeeds.get(0);
            if (operator != null) {
                BiFunction<String, String, ?> typeConverter = typeConverters.get(field);
                if (typeConverter == null)
                    throw new BusinessException(ErrorCode.INVALID_FIELD_NAME, ErrorCode.INVALID_FIELD_NAME.getMessage());

                if (operator == SearchOperator.IN) {
                    List<?> convertedValues = Arrays.stream(stringValue.split(LIST_DELIMITER))
                            .map(value -> typeConverter.apply(field, value))
                            .collect(Collectors.toList());
                    return new SearchCriteria<>(field, operator, convertedValues);
                } else {
                    return new SearchCriteria<>(field, operator, typeConverter.apply(field, stringValue));
                }
            } else {
                throw new BusinessException(ErrorCode.INVALID_FILTER_OPERATOR,
                        String.format("Operator %s is invalid, accepted: %s", stringOperator,
                                Arrays.toString(SearchOperator.values())));
            }
        } catch (IndexOutOfBoundsException e) {
            throw new BusinessException(ErrorCode.MISSING_PARAMETER, ErrorCode.MISSING_PARAMETER.getMessage());
        }
    }


    private static List<String> splitStringToList(String search, String delimiter) {
        return Arrays.asList(search.split(delimiter));
    }
}
