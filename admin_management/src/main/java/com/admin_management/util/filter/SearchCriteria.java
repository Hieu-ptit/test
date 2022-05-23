package com.admin_management.util.filter;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class SearchCriteria<T> {
    private String key;
    private T value;
    private SearchOperator operator;

    public SearchCriteria(String key, SearchOperator operator, T value) {
        this.key = key;
        this.value = value;
        this.operator = operator;
    }


}
