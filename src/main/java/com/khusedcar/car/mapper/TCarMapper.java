package com.khusedcar.car.mapper;

import com.khusedcar.car.entities.TCar;
import com.khusedcar.utils.reqdto.car.carRecordDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TCarMapper {

    /**
     * 查询所有在售车辆
     * @param tCar
     * @return
     */
    List<TCar> findAllCar(TCar tCar);

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
    List<TCar> findCarBy(@Param("brand") String brand, @Param("price") String price, @Param("carAge")String carAge, @Param("mileage")String mileage,@Param("colour") String colour, @Param("fuelType")String fuelType);

    /**
     * 新增车源
     * @param tCar
     * @return
     */
    Integer addCar(TCar tCar);

    /**
     * 车辆销售完成
     * @param id
     * @return
     */
    Integer finishCar(String id);

    /**
     * 删除车辆
     * @param id
     * @return
     */
    Integer deleteCar(Integer id);

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