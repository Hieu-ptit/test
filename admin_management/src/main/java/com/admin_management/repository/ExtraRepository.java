package com.admin_management.repository;

public interface ExtraRepository {

    /**
     * Get next value of sequence in database
     *
     * @param sequenceName
     * @return no number
     */
    Long getNextValueSeq(String sequenceName);
}
