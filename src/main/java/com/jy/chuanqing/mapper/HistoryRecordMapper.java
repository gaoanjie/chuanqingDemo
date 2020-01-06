package com.jy.chuanqing.mapper;

import com.jy.chuanqing.domain.HistoryRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface HistoryRecordMapper {
/**
 * 查询全部
 * */
//    @Select("Select * from historyrecord order by id asc")
    List<HistoryRecord> selectAllHistoryRecord();
}
