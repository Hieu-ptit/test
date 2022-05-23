package com.admin_management.service.impl;

import com.admin_management.repository.ExtraRepository;
import com.admin_management.service.SequenceInternalService;
import com.admin_management.util.Global;
import com.common.exception.BusinessException;
import com.common.util.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SequenceInternalServiceImpl implements SequenceInternalService {

    private final ExtraRepository extraRepository;

    /**
     * generateEmployeeCode
     *
     * @return String
     */
    @Override
    public String generateEmployeeCode() {

        Long nextNoOrder = extraRepository.getNextValueSeq(Global.EMPLOYEE_CODE_NO_SEQUENCE);

        if (nextNoOrder == null)
            throw new BusinessException(ErrorCode.COULD_NOT_GENERATE_CODE, "Could not Generate code for object");

        String code = "SNV";
        String number = String.format("%04d", nextNoOrder);

        return code + number;
    }


}
