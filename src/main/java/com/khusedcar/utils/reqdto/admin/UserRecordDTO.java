package com.khusedcar.utils.reqdto.admin;

import lombok.Data;

/**
 * @author Created by Jobzher
 * @date 2018-12-12 22:24
 */
@Data
public class UserRecordDTO {

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
     * 封禁时间
     */
    private String updataTime;
}
