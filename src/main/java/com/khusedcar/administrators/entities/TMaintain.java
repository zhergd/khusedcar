package com.khusedcar.administrators.entities;

import lombok.Data;

import java.util.Date;

@Data
public class TMaintain {

    /**
     * 保养项目id
     */
    private Integer id;

    /**
     * 保养项目名称
     */
    private String name;

    /**
     * 店名
     */
    private String companyName;

    /**
     * 价钱
     */
    private Long price;

    /**
     * 联系方式
     */
    private String phone;

    /**
     * 地址
     */
    private String address;

    /**
     * 描述
     */
    private String descr;

}