package com.khusedcar.schedule.controller;

import com.khusedcar.schedule.entities.TSchedule;
import com.khusedcar.schedule.service.TScheduleService;
import com.khusedcar.user.entities.TSalesman;
import com.khusedcar.utils.ResultVO;
import com.khusedcar.utils.ResultVOUtil;
import com.khusedcar.utils.enums.ResultEnums;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author Created by Jobzher
 * @date 2018-10-31 9:37
 */
@Slf4j
@RestController
@RequestMapping("/schedule")
public class TScheduleController {

    @Autowired
    private TScheduleService tScheduleService;

    @GetMapping("/findSchedule")
    public ResultVO findSchedule(String salesmanId,HttpSession session) {
        TSalesman tSalesman = (TSalesman) session.getAttribute("username");
        salesmanId = tSalesman.getId();
        log.info("【查找所有待办事务】 用户id = {}", salesmanId);
        List<TSchedule> scheduleList = tScheduleService.findSchedule(salesmanId);
        if (scheduleList != null) {
            return ResultVOUtil.success(scheduleList, ResultEnums.SUCCESS);
        } else {
            return ResultVOUtil.failed(ResultEnums.SCHEDULE_FIND_ERROR);
        }
    }

    @PostMapping("/addSchedule")
    public ResultVO addSchedule(TSchedule tSchedule, HttpSession session) {
        TSalesman tSalesman = (TSalesman) session.getAttribute("username");
        tSchedule.setSalesmanId(tSalesman.getId());
        log.info("【新增待办事务】 请求参数 = {}", tSchedule);
        boolean newSchedule = tScheduleService.addSchedule(tSchedule);
        if (newSchedule) {
            return ResultVOUtil.success(null, ResultEnums.SUCCESS);
        } else {
            return ResultVOUtil.failed(ResultEnums.NEW_SCHEDULE_ERROR);
        }
    }

    @GetMapping("/finishSchedule")
    public ResultVO finishSchedule(@RequestParam(value = "id") String id) {
        log.info("【待办事务完成】 待办事务id = {}", id);
        boolean finishSchedule = tScheduleService.finishSchedule(id);
        if (finishSchedule) {
            return ResultVOUtil.success(null, ResultEnums.SUCCESS);
        } else {
            return ResultVOUtil.failed(ResultEnums.SCHEDULE_FINISH_ERROR);
        }
    }

    @GetMapping("/deleteSchedule")
    public ResultVO deleteSchedule(@RequestParam(value = "id") String id) {
        log.info("【删除待办事务】 待办事务id = {}", id);
        boolean deleteSchedule = tScheduleService.deleteSchedule(id);
        if (deleteSchedule) {
            return ResultVOUtil.success(null, ResultEnums.SUCCESS);
        } else {
            return ResultVOUtil.failed(ResultEnums.SCHEDULE_DELETE_ERROR);
        }
    }
}
