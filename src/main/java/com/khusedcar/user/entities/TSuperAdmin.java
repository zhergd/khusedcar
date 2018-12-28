package com.khusedcar.user.entities;

import lombok.Data;

/**
 * 超级管理员对象
 * @author Created by Jobzher
 * @date 2018-11-15 10:26
 */
@Data
public class TSuperAdmin {

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;
}
