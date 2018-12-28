package com.khusedcar.schedule.mapper;

import com.khusedcar.schedule.entities.TSchedule;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TScheduleMapper {

    /**
     * 查询所有待办事务
     *
     * @param salesmanId
     * @return
     */
    List<TSchedule> findSchedule(String salesmanId);

    /**
     * 增加待办事务
     *
     * @param tSchedule
     * @return
     */
    Integer addSchedule(TSchedule tSchedule);

    /**
     * 待办事务完成
     *
     * @param id
     * @return
     */
    Integer finishSchedule(String id);

    /**
     * 删除待办事务
     *
     * @param id
     * @return
     */
    Integer deleteSchedule(String id);

}