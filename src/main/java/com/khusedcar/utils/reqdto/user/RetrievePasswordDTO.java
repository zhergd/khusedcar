package com.khusedcar.utils.reqdto.user;

import com.khusedcar.utils.PasswordMD5Encode;
import lombok.Data;

/**
 * @author Created by Jobzher
 * @date 2018-11-19 16:04
 */
@Data
public class RetrievePasswordDTO {


    /**
     * 账号
     */
    private String username;

    /**
     * 密码
     */
    private String password;

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
