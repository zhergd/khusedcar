package com.khusedcar.utils.reqdto.user;

import com.khusedcar.utils.PasswordMD5Encode;
import lombok.Data;

/**
 * 注册DTO对象
 * @author Created by Jobzher
 * @date 2018-10-30 12:42
 */
@Data
public class RegistyDTO {

    /**
     * 用户id
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
     * 安全问题
     */
    private String problem;

    /**
     * 安全问题答案
     */
    private String answer;


    public void md5Encode(){
        this.password = PasswordMD5Encode.pwdMD5Encode(getPassword());
    }
}
