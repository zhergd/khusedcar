package com.khusedcar.user.entities;

import lombok.Data;


/**
 * 用户的实体类
 */
@Data
public class TSalesman {

    /**
     * 业务员id
     */
    private String id;

    /**
     * 业务员账号
     */
    private String username;

    /**
     * 业务员密码
     */
    private String password;

    /**
     * 业务员名称
     */
    private String name;

    /**
     * 电话
     */
    private String phone;

    /**
     * 企业名称
     */
    private String companyName;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 邀请码
     */
    private String invitationCode;

    /**
     * 车源数量
     */
    private String carNum;

    /**
     * 安全问题
     */
    private String problem;

    /**
     * 安全问题答案
     */
    private String answer;


}

