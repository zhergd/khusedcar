package com.khusedcar.utils.reqdto.admin;

import lombok.Data;

/**
 * @author Created by Jobzher
 * @date 2018-12-08 16:32
 */
@Data
public class TInsuranceRecordDTO{

    /**
     * 保险id
     */
    private Integer id;

    /**
     * 保险名称
     */
    private String name;

    /**
     * 价钱
     */
    private Long price;

    /**
     * 描述
     */
    private String descr;

    /**
     * 电话
     */
    private String phone;

    /**
     * 经纪人
     */
    private String agent;

    /**
     * 更新时间
     */
    private String updataTime;

}