package com.khusedcar.administrators.service;

import com.khusedcar.administrators.entities.TInsurance;
import com.khusedcar.utils.reqdto.admin.TInsuranceRecordDTO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Created by Jobzher
 * @date 2018-11-13 20:50
 */
public interface TInsuranceService {

    /**
     * 新增保险项目
     * @param tInsurance
     * @return
     */
    Integer newTInsurance(TInsurance tInsurance);

    /**
     * 查询所有保险项目
     * @param tInsurance
     * @return
     */
    List<TInsurance> findAllTInsurance(TInsurance tInsurance);

    /**
     *  查找保险项目
     * @param name
     * @return
     */
    List<TInsurance> findTInsurance(String name);

    /**
     * 删除保险项目
     * @param id
     * @return
     */
    Integer deleteTInsurance(Integer id);

    /**
     * 操作记录
     * @param dto
     * @return
     */
    List<TInsuranceRecordDTO> findRecord(TInsuranceRecordDTO dto);

    /**
     * 删除恢复
     * @param id
     * @return
     */
    Integer recoveryTInsurance(Integer id);
}
