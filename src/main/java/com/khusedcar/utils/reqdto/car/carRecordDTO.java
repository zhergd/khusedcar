package com.khusedcar.utils.reqdto.car;

import lombok.Data;

/**
 * @author Created by Jobzher
 * @date 2018-12-09 16:37
 */
@Data
public class carRecordDTO {

    /**
     * 车源编号
     */
    private Integer id;

    /**
     * 车辆名称
     */
    private String name;

    /**
     * 企业名称
     */
    private String companyName;

    /**
     * 业务员名称
     */
    private String salesmanName;

    /**
     * 业务员电话
     */
    private String salesmanPhone;

    /**
     * 车主
     */
    private String owner;

    /**
     * 车主电话
     */
    private String ownerPhone;

    /**
     * 地址
     */
    private String address;

    /**
     * 车牌
     */
    private String carNum;

    /**
     * 汽车品牌
     */
    private String brand;

    /**
     * 价格
     */
    private String price;

    /**
     * 车龄
     */
    private String carAge;

    /**
     * 里程
     */
    private String mileage;

    /**
     * 颜色
     */
    private String colour;

    /**
     * 燃料类型  0:石油 1:电能
     */
    private String fuelType;

    /**
     * 销售类型 0:代售 1:已收购
     */
    private String saleType;

    /**
     * 卖车意向 0:急售 1:正常
     */
    private String intention;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 修改时间
     */
    private String updataTime;
}
