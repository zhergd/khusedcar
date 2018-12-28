package com.khusedcar.user.mapper;

import com.khusedcar.user.entities.Key;
import com.khusedcar.user.entities.TSalesman;

import java.util.List;

import com.khusedcar.user.entities.TSuperAdmin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TSalesmanMapper {

    /**
     * 登陆校验
     *
     * @param tSalesman 用户对象
     * @return
     */
    TSalesman login(TSalesman tSalesman);

    /**
     * 注册用户
     */
    Integer addUser(TSalesman tSalesman);

    /**
     * 查询用户
     */
    List<TSalesman> findUserBy(String name, String companyName);

    /**
     * 修改用户资料
     */
    Integer upUser(TSalesman tSalesman);

    /**
     * 修改密码
     *
     * @param tSalesman
     * @return
     */
    Integer upPassword(TSalesman tSalesman);

    /**
     * 锁定用户
     *
     * @param id
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
     * @param invitationCode
     * @return
     */
    Integer newKey(String invitationCode);

    /**
     * 查询所有Key
     * @param key
     * @return
     */
    List<Key> findKey(Key key);

    /**
     * 邀请码使用
     * @param invitationCode
     * @return
     */
    Integer upKey(String invitationCode);

    /**
     * 根据安全问题找回密码
     * @param tSalesman
     * @return
     */
    Integer retrievePassword(TSalesman tSalesman);

    /**
     * 超级管理员登录校验
     * @param tSuperAdmin
     * @return
     */
    TSuperAdmin adminLogin(TSuperAdmin tSuperAdmin);

}