package com.admin_management.util.filter;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.NonNull;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class SpecificationBuilder<T> implements Specification<T> {

    private static final Map<SearchOperator, TriFunction<SearchCriteria, CriteriaBuilder, Root, Predicate>> FILTER_CRITERIA = new EnumMap<>(SearchOperator.class);

    static {
        FILTER_CRITERIA.put(SearchOperator.GREATER_THAN, (criteria, criteriaBuilder, root) -> criteriaBuilder.greaterThan(root.get(criteria.getKey()), (Comparable) criteria.getValue()));
        FILTER_CRITERIA.put(SearchOperator.LESS_THAN, (criteria, criteriaBuilder, root) -> criteriaBuilder.lessThan(root.get(criteria.getKey()), (Comparable) criteria.getValue()));
        FILTER_CRITERIA.put(SearchOperator.EQUAL, (criteria, criteriaBuilder, root) -> criteriaBuilder.equal(root.get(criteria.getKey()), criteria.getValue()));
        FILTER_CRITERIA.put(SearchOperator.LIKE, (criteria, criteriaBuilder, root) -> criteriaBuilder.like(criteriaBuilder.upper(root.get(criteria.getKey())), "%" + criteria.getValue().toString().toUpperCase() + "%"));
        FILTER_CRITERIA.put(SearchOperator.IN, (criteria, criteriaBuilder, root) -> criteriaBuilder.in(root.get(criteria.getKey())).value(criteria.getValue()));
        FILTER_CRITERIA.put(SearchOperator.NOT_EQUAL, (criteria, criteriaBuilder, root) -> criteriaBuilder.notEqual(root.get(criteria.getKey()), criteria.getValue()));
        FILTER_CRITERIA.put(SearchOperator.GREATER_THAN_EQUAL, (criteria, criteriaBuilder, root) -> criteriaBuilder.greaterThanOrEqualTo(root.get(criteria.getKey()), (Comparable) criteria.getValue()));
        FILTER_CRITERIA.put(SearchOperator.LESS_THAN_EQUAL, (criteria, criteriaBuilder, root) -> criteriaBuilder.lessThanOrEqualTo(root.get(criteria.getKey()), (Comparable) criteria.getValue()));
    }

    private final List<SearchCriteria> list = new ArrayList<>();

    public SpecificationBuilder() {
    }

    public void add(SearchCriteria criteria) {
        this.list.add(criteria);
    }

    @Override
    public Predicate toPredicate(@NonNull Root<T> root, @NonNull CriteriaQuery<?> query, @NonNull CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();
        for (SearchCriteria searchCriteria : this.list)
            predicates.add(FILTER_CRITERIA.get(searchCriteria.getOperator()).apply(searchCriteria, criteriaBuilder, root));

        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }

    public SpecificationBuilder(List<SearchCriteria> list) {
        this.list.addAll(list);
    }
}
