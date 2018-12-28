package com.khusedcar.utils.reqdto.admin;

import lombok.Data;

/**
 * @author Created by Jobzher
 * @date 2018-12-08 18:02
 */
@Data
public class TMaintainRecordDTO {

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

    /**
     * 修改时间
     */
    private String updataTime;
}
