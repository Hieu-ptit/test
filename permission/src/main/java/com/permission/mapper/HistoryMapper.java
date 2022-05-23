package com.permission.mapper;

import com.permission.model.entity.History;
import com.permission.model.request.HistoryRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class HistoryMapper {

    public History map(HistoryRequest historyRequest){
        return new History()
                .setCode(historyRequest.getCode())
                .setName(historyRequest.getName())
                .setDescription(historyRequest.getDescription());
    }
}
