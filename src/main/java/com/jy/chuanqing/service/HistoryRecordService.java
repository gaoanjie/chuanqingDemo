package com.jy.chuanqing.service;

import com.jy.chuanqing.domain.HistoryRecord;
import com.jy.chuanqing.mapper.HistoryRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryRecordService {
    @Autowired
    HistoryRecordMapper historyRecordMapper;

    public List<HistoryRecord> selectAllHistoryRecord() {
        return historyRecordMapper.selectAllHistoryRecord();
    }
}
