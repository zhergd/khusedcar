package com.khusedcar.administrators.service.impl;

import com.khusedcar.administrators.entities.TMaintain;
import com.khusedcar.administrators.mapper.AdminMapper;
import com.khusedcar.administrators.service.AdminService;
import com.khusedcar.utils.reqdto.admin.UserRecordDTO;
import com.khusedcar.utils.reqdto.user.PasswordDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Created by Jobzher
 * @date 2018-12-12 1:03
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public List<TMaintain> findAllUser(TMaintain tMaintain) {
        List<TMaintain> tMaintainList = adminMapper.findAllUser(tMaintain);
        return tMaintainList;
    }

    @Override
    public List<TMaintain> findUserBy(String name) {
        List<TMaintain> tMaintainList = adminMapper.findUserBy(name);
        return tMaintainList;
    }

    @Override
    public Integer resetPassword(PasswordDTO dto) {
        Integer result = adminMapper.resetPassword(dto);
        return result;
    }

    @Override
    public Integer blockedUser(Integer id) {
        Integer result = adminMapper.blockedUser(id);
        return result;
    }

    @Override
    public List<UserRecordDTO> findBlockedUser() {
        List<UserRecordDTO> userRecordDTOList = adminMapper.findBlockedUser();
        return userRecordDTOList;
    }

    @Override
    public Integer liftedUser(Integer id) {
        Integer result = adminMapper.liftedUser(id);
        return result;
    }
}
