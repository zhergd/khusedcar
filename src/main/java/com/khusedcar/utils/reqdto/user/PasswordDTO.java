package com.khusedcar.utils.reqdto.user;

import com.khusedcar.utils.PasswordMD5Encode;
import lombok.Data;

/**
 * 更改密码DTO对象
 * @author Created by Jobzher
 * @date 2018-10-30 1:32
 */
@Data
public class PasswordDTO {

    /**
     * 用户id
     */
    private String id;

    /**
     * 业务员密码
     */
    private String password;

    public void md5Encode(){
        this.password = PasswordMD5Encode.pwdMD5Encode(getPassword());
    }

}
