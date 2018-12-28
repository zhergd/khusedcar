package com.khusedcar.administrators.entities;

import lombok.Data;


@Data
public class TInsurance {

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

}