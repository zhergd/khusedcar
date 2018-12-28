package com.khusedcar.utils.reqdto.user;

import com.khusedcar.utils.PasswordMD5Encode;
import lombok.Data;

/**
 * 登录DTO对象
 * @author Created by Jobzher
 * @date 2018-10-29 23:41
 */
@Data
public class LoginDTO {

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


    public void md5Encode(){
        this.password = PasswordMD5Encode.pwdMD5Encode(getPassword());
    }
}
