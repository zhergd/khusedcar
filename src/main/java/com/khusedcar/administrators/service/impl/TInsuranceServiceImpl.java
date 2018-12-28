package com.khusedcar.administrators.service.impl;

import com.khusedcar.administrators.entities.TInsurance;
import com.khusedcar.administrators.mapper.TInsuranceMapper;
import com.khusedcar.administrators.service.TInsuranceService;
import com.khusedcar.utils.reqdto.admin.TInsuranceRecordDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Created by Jobzher
 * @date 2018-11-13 20:50
 */
@Service
public class TInsuranceServiceImpl implements TInsuranceService {

    @Autowired
    private TInsuranceMapper tInsuranceMapper;

    @Override
    public Integer newTInsurance(TInsurance tInsurance) {
        Integer result = tInsuranceMapper.newTInsurance(tInsurance);
        return result;
    }

    @Override
    public List<TInsurance> findAllTInsurance(TInsurance tInsurance) {
        List<TInsurance> tInsuranceList = tInsuranceMapper.findAllTInsurance(tInsurance);
        return tInsuranceList;
    }

    @Override
    public List<TInsurance> findTInsurance(String name) {
        List<TInsurance> tInsuranceList = tInsuranceMapper.findTInsurance(name);
        return tInsuranceList;
    }

    @Override
    public Integer deleteTInsurance(Integer id) {
        Integer result = tInsuranceMapper.deleteTInsurance(id);
        return result;
    }

    @Override
    public List<TInsuranceRecordDTO> findRecord(TInsuranceRecordDTO dto) {
        List<TInsuranceRecordDTO> tInsuranceList = tInsuranceMapper.findRecord(dto);
        return tInsuranceList;
    }

    @Override
    public Integer recoveryTInsurance(Integer id) {
        Integer result = tInsuranceMapper.recoveryTInsurance(id);
        return result;
    }
}
