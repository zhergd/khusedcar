package com.khusedcar.car.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.khusedcar.car.entities.TCar;
import com.khusedcar.car.mapper.TCarMapper;
import com.khusedcar.car.service.TCarService;
import com.khusedcar.utils.reqdto.car.carRecordDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Created by Jobzher
 * @date 2018-11-01 0:00
 */
@Service
public class TCarServiceImpl implements TCarService {

    @Autowired
    private TCarMapper tCarMapper;

    /**
     * 查询所有在售车辆
     * @param tCar
     * @return
     */
    @Override
    public PageInfo<TCar> findAllCar(TCar tCar,Integer pageNum,Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<TCar> carList = tCarMapper.findAllCar(tCar);
        PageInfo<TCar> pageInfo = new PageInfo<>(carList);
        return pageInfo;
    }

    @Override
    public List<TCar> findCar(String name) {
        List<TCar> carList = tCarMapper.findCar(name);
        return carList;
    }

    /**
     * 根据条件筛选车辆
     * @param brand
     * @param price
     * @param carAge
     * @param mileage
     * @param colour
     * @param fuelType
     * @return
     */
    @Override
    public List<TCar> findCarBy(String brand,String price,String carAge,String mileage,String colour,String fuelType) {
//        PageHelper.startPage(pageNum,pageSize);
        List<TCar> carList = tCarMapper.findCarBy(brand,price,carAge,mileage,colour,fuelType);
        System.out.print(carList);
//        PageInfo<TCar> carPageInfo = new PageInfo<>(carList);
        return carList;
    }

    @Override
    public List<TCar> findCarById(String salesmanName) {
        List<TCar> carList = tCarMapper.findCarById(salesmanName);
        return carList;
    }

    /**
     * 上报车辆
     * @param tCar
     * @return
     */
    @Override
    public boolean addCar(TCar tCar) {
        Integer result = tCarMapper.addCar(tCar);
        return result > 0;
    }

    /**
     * 车辆售出
     * @param id
     * @return
     */
    @Override
    public boolean finishCar(String id) {
        Integer result = tCarMapper.finishCar(id);
        return result > 0;
    }

    /**
     * 车辆删除
     * @param id
     * @return
     */
    @Override
    public boolean deleteCar(Integer id) {
        Integer result = tCarMapper.deleteCar(id);
        return result > 0;
    }

    @Override
    public Integer lockingCar(Integer id) {
        Integer result = tCarMapper.lockingCar(id);
        return result;
    }

    @Override
    public List<carRecordDTO> carRecord(carRecordDTO dto) {
        List<carRecordDTO> carRecordDTOList = tCarMapper.carRecord(dto);
        return carRecordDTOList;
    }

    @Override
    public List<carRecordDTO> findCarSalesRecords(carRecordDTO dto) {
        List<carRecordDTO> carRecordDTOList = tCarMapper.findCarSalesRecords(dto);
        return carRecordDTOList;
    }

    @Override
    public Integer recoveryCar(Integer id) {
        Integer result = tCarMapper.recoveryCar(id);
        return result;
    }
}
