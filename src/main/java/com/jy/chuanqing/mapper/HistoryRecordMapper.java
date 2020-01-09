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
     */
    List<HistoryRecord> selectAllHistoryRecord();

    /**
     * 根据ID查询
     */
    @Select("Select * from historyrecord where id = #{id} order by id asc")
    List<HistoryRecord> selectWhereHistoryRecord(int id);

    /**
     * 插入一条
     */
    int insertHistoryRecord(HistoryRecord historyRecord);

    /**
     * 查询正在运行的0表示运行结束，1为正在运行
     */
    @Select("Select * from historyrecord where runningstatus = 1 ")
    List<HistoryRecord> selectOneHistoryRecord();
}
