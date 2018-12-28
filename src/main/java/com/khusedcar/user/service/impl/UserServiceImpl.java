package com.khusedcar.user.service.impl;

import com.khusedcar.convert.DTOConvert;
import com.khusedcar.user.entities.Key;
import com.khusedcar.user.entities.TSalesman;
import com.khusedcar.user.entities.TSuperAdmin;
import com.khusedcar.user.mapper.TSalesmanMapper;
import com.khusedcar.user.service.UserService;
import com.khusedcar.utils.GeneralUUIDUtil;
import com.khusedcar.utils.enums.UserStatusEnum;
import com.khusedcar.utils.reqdto.user.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author Created by Jobzher
 * @date 2018-10-27 16:37
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private TSalesmanMapper tSalesmanMapper;

    /**
     * 登录校验
     *
     * @param username
     * @param password
     * @return
     */
    @Override
    public TSalesman login(String username, String password) {
        TSalesman tSalesman = new TSalesman();
        tSalesman.setUsername(username);
        tSalesman.setPassword(password);
        return tSalesmanMapper.login(tSalesman);
    }

    /**
     * 注册用户
     *
     * @param dto
     * @return
     */
    @Override
    public boolean addUesr(RegistyDTO dto) {
//        TSalesman tSalesman = new TSalesman();
//        BeanUtils.copyProperties(dto, tSalesman);
//        tSalesman.setId(GeneralUUIDUtil.uuidEncodeUserId());
        TSalesman tSalesman = null;
        try {
            tSalesman = DTOConvert.copy(dto, TSalesman.class);
        } catch (Exception e) {
            log.error("【注册】 对象转换失败,失败原因:{}", e.getMessage());
        }
        Integer result = tSalesmanMapper.addUser(tSalesman);
        return result > 0;
    }


    /**
     * 查询所有用户
     *
     * @param name
     * @param companyName
     * @return
     */
    @Override
    public List<TSalesman> findUserBy(String name, String companyName) {
        return null;
    }

    /**
     * 更改用户信息
     *
     * @param dto
     * @return
     */
    @Override
    public boolean upUser(UserDTO dto) {
        TSalesman tSalesman = null;
        try {
            tSalesman = DTOConvert.copy(dto, TSalesman.class);
        } catch (Exception e) {
            log.error("【修改用户信息】 对象转换失败,失败原因:{}", e.getMessage());
        }
        Integer result = tSalesmanMapper.upUser(tSalesman);
        return result > 0;
    }

    /**
     * 更改密码
     *
     * @param dto
     * @return
     */
    @Override
    public boolean upPassword(PasswordDTO dto) {
        TSalesman tSalesman = null;
        try {
            tSalesman = DTOConvert.copy(dto, TSalesman.class);
        } catch (Exception e) {
            log.error("【修改用户密码】 对象转换失败,失败原因:{}", e.getMessage());
        }
        Integer result = tSalesmanMapper.upPassword(tSalesman);
        return result > 0;
    }

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    @Override
    public Integer deleteUser(String id) {
        Integer result = tSalesmanMapper.deleteUser(id);
        return result;
    }

    /**
     * 根据用户名查找用户
     *
     * @param username
     * @return
     */
    @Override
    public TSalesman findUserByName(String username) {
        TSalesman tSalesman = tSalesmanMapper.findUserByName(username);
        return tSalesman;
    }

    /**
     * 生成邀请码
     * @return
     */
    @Override
    public Integer newKey() {
        TSalesman tSalesman = new TSalesman();
        tSalesman.setInvitationCode(GeneralUUIDUtil.uuidEncodeKey());
        Integer result = tSalesmanMapper.newKey(tSalesman.getInvitationCode());
        return result;
    }

    @Override
    public List<Key> findKey(Key key) {
        List<Key> keyList = tSalesmanMapper.findKey(key);
        return keyList;
    }

    @Override
    public boolean retrievePassword(RetrievePasswordDTO dto) {
        TSalesman tSalesman = null;
        try {
            tSalesman = DTOConvert.copy(dto, TSalesman.class);
        } catch (Exception e) {
            log.error("【根据安全问题找回密码】 对象转换失败,失败原因:{}", e.getMessage());
        }
        Integer result = tSalesmanMapper.retrievePassword(tSalesman);
        return result > 0;
    }

    @Override
    public Integer upKey(String invitationCode) {
        Integer result = tSalesmanMapper.upKey(invitationCode);
        return result;
    }

    @Override
    public TSuperAdmin adminLogin(String username, String password) {
        TSuperAdmin tSuperAdmin = new TSuperAdmin();
        tSuperAdmin.setUsername(username);
        tSuperAdmin.setPassword(password);
        return tSalesmanMapper.adminLogin(tSuperAdmin);
    }
}
