package com.khusedcar.administrators.mapper;

import com.khusedcar.administrators.entities.TInsurance;

import java.util.List;

import com.khusedcar.utils.reqdto.admin.TInsuranceRecordDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TInsuranceMapper {

    /**
     * 新增保险
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
     * 查询保险项目
     * @param id
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