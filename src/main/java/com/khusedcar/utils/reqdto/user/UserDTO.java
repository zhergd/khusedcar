package com.khusedcar.utils.reqdto.user;

import lombok.Data;

/**
 * 更改用户信息DTO对象
 * @author Created by Jobzher
 * @date 2018-10-30 0:09
 */
@Data
public class UserDTO {


    private String id;

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
}
