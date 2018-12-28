package com.khusedcar.administrators.service;

import com.khusedcar.administrators.entities.TMaintain;
import com.khusedcar.utils.reqdto.admin.UserRecordDTO;
import com.khusedcar.utils.reqdto.user.PasswordDTO;

import java.util.List;

/**
 * @author Created by Jobzher
 * @date 2018-12-12 1:02
 */
public interface AdminService {

    /**
     * 查询所有用户
     * @param tMaintain
     * @return
     */
    List<TMaintain> findAllUser(TMaintain tMaintain);

    /**
     * 搜索用户
     * @param name
     * @return
     */
    List<TMaintain> findUserBy(String name);

    /**
     * 重置密码
     * @param dto
     * @return
     */
    Integer resetPassword(PasswordDTO dto);

    /**
     * 封号
     * @param id
     * @return
     */
    Integer blockedUser(Integer id);

    /**
     * 查询封禁帐号
     * @return
     */
    List<UserRecordDTO> findBlockedUser();

    /**
     * 解封账号
     * @param id
     * @return
     */
    Integer liftedUser(Integer id);
}
