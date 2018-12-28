package com.khusedcar.schedule.service.impl;

import com.khusedcar.schedule.entities.TSchedule;
import com.khusedcar.schedule.mapper.TScheduleMapper;
import com.khusedcar.schedule.service.TScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Created by Jobzher
 * @date 2018-10-31 9:36
 */
@Service
public class TScheduleServiceImpl implements TScheduleService {

    @Autowired
    private TScheduleMapper tScheduleMapper;

    @Override
    public List<TSchedule> findSchedule(String salesmanId) {
        List<TSchedule> tschedulesList = tScheduleMapper.findSchedule(salesmanId);
        return tschedulesList;
    }

    @Override
    public boolean addSchedule(TSchedule tSchedule) {
        Integer result = tScheduleMapper.addSchedule(tSchedule);
        return result > 0;
    }

    @Override
    public boolean finishSchedule(String id) {
        Integer result = tScheduleMapper.finishSchedule(id);
        return result > 0;
    }

    @Override
    public boolean deleteSchedule(String id) {
        Integer result = tScheduleMapper.deleteSchedule(id);
        return result > 0;
    }
}
