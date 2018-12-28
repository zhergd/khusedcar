package com.khusedcar.administrators.mapper;

import com.khusedcar.administrators.entities.TMaintain;

import java.util.List;

import com.khusedcar.utils.reqdto.admin.TMaintainRecordDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TMaintainMapper {

    /**
     * 新增保养项目
     * @param tMaintain
     * @return
     */
    Integer newTMaintain(TMaintain tMaintain);

    /**
     * 查询所有保养项目
     * @param tMaintain
     * @return
     */
    List<TMaintain> findAllTMaintain(TMaintain tMaintain);

    /**
     * 查询保养项目
     * @param name
     * @return
     */
    List<TMaintain> findTMaintain(String name);

    /**
     * 删除保养项目
     * @param id
     * @return
     */
    Integer deleteTMaintain(String id);

    /**
     * 操作记录
     * @param dto
     * @return
     */
    List<TMaintainRecordDTO> getRecord(TMaintainRecordDTO dto);

    /**
     * 删除恢复
     * @param id
     * @return
     */
    Integer recoveryTMaintain(Integer id);

}