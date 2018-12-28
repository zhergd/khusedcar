package com.khusedcar.schedule.service;

import com.khusedcar.schedule.entities.TSchedule;

import java.util.List;

/**
 * @author Created by Jobzher
 * @date 2018-10-31 9:35
 */
public interface TScheduleService {

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
    boolean addSchedule(TSchedule tSchedule);

    /**
     * 待办事务完成
     *
     * @param id
     * @return
     */
    boolean finishSchedule(String id);

    /**
     * 删除待办事务
     *
     * @param id
     * @return
     */
    boolean deleteSchedule(String id);
}
