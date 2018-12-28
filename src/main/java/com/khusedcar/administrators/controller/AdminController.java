package com.khusedcar.administrators.controller;

import com.khusedcar.administrators.entities.TInsurance;
import com.khusedcar.administrators.entities.TMaintain;
import com.khusedcar.administrators.service.AdminService;
import com.khusedcar.administrators.service.TInsuranceService;
import com.khusedcar.administrators.service.TMaintainService;
import com.khusedcar.utils.ResultVO;
import com.khusedcar.utils.ResultVOUtil;
import com.khusedcar.utils.enums.ResultEnums;
import com.khusedcar.utils.reqdto.admin.TInsuranceRecordDTO;
import com.khusedcar.utils.reqdto.admin.TMaintainRecordDTO;
import com.khusedcar.utils.reqdto.admin.UserRecordDTO;
import com.khusedcar.utils.reqdto.user.PasswordDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Created by Jobzher
 * @date 2018-11-14 14:29
 */
@Slf4j
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private TInsuranceService tInsuranceService;

    @Autowired
    private TMaintainService tMaintainService;

    @Autowired
    private AdminService adminService;

    @PostMapping("/newTInsurance")
    public ResultVO newTInsurance (TInsurance tInsurance){
        log.info("【新增保险项目】 请求参数 = {}",tInsurance);
        Integer result = tInsuranceService.newTInsurance(tInsurance);
        if (result > 0){
            return ResultVOUtil.success(null,ResultEnums.SUCCESS);
        }else {
            return ResultVOUtil.failed(ResultEnums.ADMIN_ADDTINSURANCE_ERROR);
        }
    }

    @GetMapping("/findTInsurance")
    public ResultVO<List<TInsurance>> findAllTInsurance(@RequestBody(required = false) TInsurance tInsurance){
        log.info("【查询所有保险项目】 请求参数 = {}",tInsurance);
        List<TInsurance> tInsuranceList = tInsuranceService.findAllTInsurance(tInsurance);
        if (tInsuranceList != null){
            return ResultVOUtil.success(tInsuranceList,ResultEnums.SUCCESS);
        }else {
            return ResultVOUtil.failed(ResultEnums.ADMIN_FINDTINSURANCE_ERROR);
        }
    }

    @GetMapping("/getTInsurance")
    public ResultVO<List<TInsurance>> findTInsurance(@RequestParam(value = "name")String name){
        log.info("【查询保险项目】 请求参数 = {}",name );
        List<TInsurance> tInsuranceList = tInsuranceService.findTInsurance(name);
        if (tInsuranceList != null){
            return ResultVOUtil.success(tInsuranceList,ResultEnums.SUCCESS);
        }else {
            return ResultVOUtil.failed(ResultEnums.ADMIN_FINDTINSURANCE_ERROR);
        }
    }

    @GetMapping("/deleteTInsurance")
    public ResultVO deleteTInsurance(@RequestParam(value = "id")Integer id){
        log.info("【删除保险项目】 请求参数 = {}",id);
        Integer result = tInsuranceService.deleteTInsurance(id);
        if (result > 0){
            return ResultVOUtil.success(null,ResultEnums.SUCCESS);
        }else {
            return ResultVOUtil.failed(ResultEnums.ADMIN_DELETETINSURANCE_ERROR);
        }
    }

    @GetMapping("/findRecord")
    public ResultVO<List<TInsuranceRecordDTO>> findRecord(TInsuranceRecordDTO dto) {
        log.info("【操作记录】 请求参数 = {}", dto);
        List<TInsuranceRecordDTO> tInsuranceList = tInsuranceService.findRecord(dto);
        System.out.print(tInsuranceList);
        if (dto != null) {
            return ResultVOUtil.success(tInsuranceList, ResultEnums.SUCCESS);
        } else {
            return ResultVOUtil.failed(ResultEnums.ADMIN_RECORD_ERROR);
        }
    }

    @GetMapping("/recoveryTInsurance")
    public ResultVO recoveryTInsurance(@RequestParam(value = "id")Integer id){
        log.info("【删除恢复】 请求参数 = {}",id);
        Integer result = tInsuranceService.recoveryTInsurance(id);
        if (result > 0){
            return ResultVOUtil.success(null,ResultEnums.SUCCESS);
        }else {
            return ResultVOUtil.failed(ResultEnums.ADMIN_RECOVERY_ERROR);
        }
    }


    @PostMapping("/newTMaintain")
    public ResultVO newTMaintain(TMaintain tMaintain){
        log.info("【新增保养项目】 请求参数 = {}",tMaintain );
        Integer result = tMaintainService.newTMaintain(tMaintain);
        if (result > 0){
            return ResultVOUtil.success(null,ResultEnums.SUCCESS);
        }else {
            return ResultVOUtil.failed(ResultEnums.ADMIN_ADDTMAINTAIN_ERROR);
        }
    }

    @GetMapping("/findTMaintain")
    public ResultVO<List<TMaintain>> findAllTMaintain(@RequestBody(required = false) TMaintain tMaintain){
        log.info("【查询所有保养项目】 请求参数 = {}",tMaintain);
        List<TMaintain> tMaintainList = tMaintainService.findAllTMaintain(tMaintain);
        if (tMaintainList != null){
            return ResultVOUtil.success(tMaintainList,ResultEnums.SUCCESS);
        }else {
            return ResultVOUtil.failed(ResultEnums.ADMIN_FINDTMAINTAIN_ERROR);
        }
    }

    @GetMapping("/getTMaintain")
    public ResultVO<List<TMaintain>> findTMaintain(@RequestParam(value = "name") String name){
        log.info("【查询保养项目】 请求参数 = {}",name);
        List<TMaintain> tMaintainList = tMaintainService.findTMaintain(name);
        if (tMaintainList != null){
            return ResultVOUtil.success(tMaintainList,ResultEnums.SUCCESS);
        }else {
            return ResultVOUtil.failed(ResultEnums.ADMIN_FINDTMAINTAIN_ERROR);
        }
    }

    @GetMapping("/deleteTMaintain")
    public ResultVO deleteTMaintain(@RequestParam(value = "id")String id){
        log.info("【删除保养项目】 请求参数 = {}",id);
        Integer result = tMaintainService.deleteTMaintain(id);
        if (result > 0){
            return ResultVOUtil.success(null,ResultEnums.SUCCESS);
        }else {
            return ResultVOUtil.failed(ResultEnums.ADMIN_DELETETMAINTAIN_ERROR);
        }
    }

    @GetMapping("/getRecord")
    public ResultVO<List<TMaintainRecordDTO>> getRecord(TMaintainRecordDTO dto){
        log.info("【操作记录】 请求参数 = {}",dto);
        List<TMaintainRecordDTO> tMaintainList = tMaintainService.getRecord(dto);
        if (tMaintainList != null){
            return ResultVOUtil.success(tMaintainList,ResultEnums.SUCCESS);
        }else {
            return ResultVOUtil.failed(ResultEnums.ADMIN_RECORD_ERROR);
        }
    }

    @GetMapping("/recoveryTMaintain")
    public ResultVO recoveryTMaintain(@RequestParam(value = "id") Integer id){
        log.info("【删除恢复】 请求参数 = {}",id);
        Integer result = tMaintainService.recoveryTMaintain(id);
        if (result > 0){
            return ResultVOUtil.success(null,ResultEnums.SUCCESS);
        }else {
            return ResultVOUtil.failed(ResultEnums.ADMIN_RECOVERY_ERROR);
        }
    }

    @GetMapping("/findAllUser")
    public ResultVO<List<TMaintain>> findAllUser(TMaintain tMaintain){
        log.info("【查询所有用户】 请求参数 = {}",tMaintain);
        List<TMaintain> tMaintainList = adminService.findAllUser(tMaintain);
        if (tMaintainList != null){
            return ResultVOUtil.success(tMaintainList,ResultEnums.SUCCESS);
        }else {
            return ResultVOUtil.failed(ResultEnums.USER_FIND_ERROR);
        }
    }

    @GetMapping("/findUserBy")
    public ResultVO<List<TMaintain>> findUserBy(@RequestParam(value = "name") String name){
        log.info("【搜索用户】 请求参数 = {}",name);
        List<TMaintain> tMaintainList = adminService.findUserBy(name);
        if (tMaintainList != null){
            return ResultVOUtil.success(tMaintainList,ResultEnums.SUCCESS);
        }else {
            return ResultVOUtil.failed(ResultEnums.USER_FIND_ERROR);
        }
    }

    @GetMapping("/resetPassword")
    public ResultVO resetPassword(PasswordDTO dto){
        dto.md5Encode();
        log.info("【重置密码】 请求参数 = {}",dto);
        Integer result = adminService.resetPassword(dto);
        if (result > 0){
            return ResultVOUtil.success(null,ResultEnums.SUCCESS);
        }else {
            return ResultVOUtil.failed(ResultEnums.USER_RETRIEVE_ERROR);
        }
    }

    @GetMapping("/blockedUser")
    public ResultVO blockedUser(@RequestParam(value = "id") Integer id){
        log.info("【账号封禁】 请求参数 = {}",id);
        Integer result = adminService.blockedUser(id);
        if (result > 0){
            return ResultVOUtil.success(null,ResultEnums.SUCCESS);
        }else {
            return ResultVOUtil.failed(ResultEnums.USER_DELECT_ERROR);
        }
    }

    @GetMapping("/findBlockedUser")
    public ResultVO<List<UserRecordDTO>> findBlockedUser(){
        log.info("【查询封禁账户】");
        List<UserRecordDTO> userRecordDTOList = adminService.findBlockedUser();
        if (userRecordDTOList != null){
            return ResultVOUtil.success(userRecordDTOList,ResultEnums.SUCCESS);
        }else {
            return ResultVOUtil.failed(ResultEnums.ADMIN_RECORD_ERROR);
        }
    }

    @GetMapping("/liftedUser")
    public ResultVO liftedUser(@RequestParam(value = "id")Integer id){
        log.info("【解封账号】 请求参数 = {}",id);
        Integer result = adminService.liftedUser(id);
        if (result > 0){
            return ResultVOUtil.success(null,ResultEnums.SUCCESS);
        }else {
            return ResultVOUtil.failed(ResultEnums.ADMIN_RECOVERY_ERROR);
        }
    }

}
