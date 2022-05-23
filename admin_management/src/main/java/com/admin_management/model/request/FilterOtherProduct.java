package com.admin_management.model.request;

import com.admin_management.model.bo.SortedField;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.domain.Sort;

@Data
@Accessors(chain = true)
public class FilterOtherProduct {

    private String searchedText;

    private SortedField sortedField;

    private Sort.Direction sortedType;

    private int page;

    private int size;

    public static FilterOtherProduct build() {
        return new FilterOtherProduct();
    }
}
