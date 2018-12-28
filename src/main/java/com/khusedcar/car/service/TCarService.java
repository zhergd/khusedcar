package com.khusedcar.car.service;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.khusedcar.car.entities.TCar;
import com.khusedcar.utils.reqdto.car.carRecordDTO;

import java.util.List;

public interface TCarService {
    /**
     * 查询所有在售车辆
     * @param tCar
     * @return
     */
    PageInfo<TCar> findAllCar(TCar tCar,Integer pageNum,Integer pageSize);

    /**
     * 根据名字查找车辆
     * @param name
     * @return
     */
    List<TCar> findCar(String name);

    /**
     * 根据业务员查找车辆
     * @param salesmanName
     * @return
     */
    List<TCar> findCarById(String salesmanName);

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
    List<TCar> findCarBy(String brand,String price,String carAge,String mileage,String colour,String fuelType);

    /**
     * 新增车源
     * @param tCar
     * @return
     */
    boolean addCar(TCar tCar);

    /**
     * 车辆销售完成
     * @param id
     * @return
     */
    boolean finishCar(String id);

    /**
     * 删除车源
     * @param id
     * @return
     */
    boolean deleteCar(Integer id);

    /**
     * 锁定车辆
     * @param id
     * @return
     */
    Integer lockingCar(Integer id);

    /**
     * 查询操作后的车辆
     * @param dto
     * @return
     */
    List<carRecordDTO> carRecord(carRecordDTO dto);

    /**
     * 查看交易记录
     * @param dto
     * @return
     */
    List<carRecordDTO> findCarSalesRecords(carRecordDTO dto);

    /**
     * 操作恢复
     * @param id
     * @return
     */
    Integer recoveryCar(Integer id);

}