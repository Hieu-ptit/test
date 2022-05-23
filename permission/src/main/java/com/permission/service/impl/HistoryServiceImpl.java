package com.permission.service.impl;

import com.permission.mapper.HistoryMapper;
import com.permission.model.entity.History;
import com.permission.model.request.HistoryRequest;
import com.permission.repository.HistoryRepository;
import com.permission.service.HistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HistoryServiceImpl implements HistoryService {

    public final HistoryRepository historyRepository;
    public final HistoryMapper historyMapper;

    @Override
    public Boolean create(HistoryRequest historyRequest) {

        History history = historyMapper.map(historyRequest);

        historyRepository.insert(history);

        return true;
    }
}
