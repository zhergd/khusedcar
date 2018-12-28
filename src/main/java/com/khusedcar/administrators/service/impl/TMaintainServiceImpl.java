package com.khusedcar.administrators.service.impl;

import com.khusedcar.administrators.entities.TMaintain;
import com.khusedcar.administrators.mapper.TMaintainMapper;
import com.khusedcar.administrators.service.TMaintainService;
import com.khusedcar.utils.reqdto.admin.TMaintainRecordDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Created by Jobzher
 * @date 2018-11-13 20:50
 */
@Service
public class TMaintainServiceImpl implements TMaintainService {

    @Autowired
    private TMaintainMapper tMaintainMapper;

    @Override
    public Integer newTMaintain(TMaintain tMaintain) {
        Integer result = tMaintainMapper.newTMaintain(tMaintain);
        return result;
    }

    @Override
    public List<TMaintain> findAllTMaintain(TMaintain tMaintain) {
        List<TMaintain> tMaintainList = tMaintainMapper.findAllTMaintain(tMaintain);
        return tMaintainList;
    }

    @Override
    public List<TMaintain> findTMaintain(String name) {
        List<TMaintain> tMaintainList = tMaintainMapper.findTMaintain(name);
        return tMaintainList;
    }

    @Override
    public Integer deleteTMaintain(String id) {
        Integer result = tMaintainMapper.deleteTMaintain(id);
        return result;
    }

    @Override
    public List<TMaintainRecordDTO> getRecord(TMaintainRecordDTO dto) {
        List<TMaintainRecordDTO> tMaintainList = tMaintainMapper.getRecord(dto);
        return tMaintainList;
    }

    @Override
    public Integer recoveryTMaintain(Integer id) {
        Integer result = tMaintainMapper.recoveryTMaintain(id);
        return result;
    }
}
