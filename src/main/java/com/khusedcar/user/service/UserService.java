package com.khusedcar.user.service;

import com.khusedcar.user.entities.Key;
import com.khusedcar.user.entities.TSalesman;
import com.khusedcar.user.entities.TSuperAdmin;
import com.khusedcar.utils.reqdto.user.*;

import java.util.List;

/**
 * 用户Service
 *
 * @author Created by Jobzher
 * @date 2018-10-27 16:37
 */
public interface UserService {


    /**
     * 登录校验
     *
     * @param username
     * @param password
     * @return
     */
    TSalesman login(String username, String password);

    /**
     * 注册用户
     *
     * @param dto
     * @return
     */
    boolean addUesr(RegistyDTO dto);


    /**
     * 查询用户
     */
    List<TSalesman> findUserBy(String name, String companyName);

    /**
     * 修改用户
     */
    boolean upUser(UserDTO dto);

    /**
     * 修改密码
     *
     * @param dto
     * @return
     */
    boolean upPassword(PasswordDTO dto);

    /**
     * 锁定用户
     */
    Integer deleteUser(String id);

    /**
     * 根据用户名称查找用户
     *
     * @param username
     * @return
     */
    TSalesman findUserByName(String username);

    /**
     * 生成邀请码
     *
     * @param
     * @return
     */
    Integer newKey();

    /**
     * 查询所有Key
     * @param key
     * @return
     */
    List<Key> findKey(Key key);


    /**
     * 邀请码使用
     *
     * @param invitationCode
     * @return
     */
    Integer upKey(String invitationCode);

    /**
     * 根据安全问题找回密码
     *
     * @param dto
     * @return
     */
    boolean retrievePassword(RetrievePasswordDTO dto);

    /**
     * 超级管理员登录校验
     *
     * @param username
     * @param password
     * @return
     */
    TSuperAdmin adminLogin(String username, String password);


}
