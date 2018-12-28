package com.khusedcar.utils;


import sun.misc.BASE64Encoder;

import java.security.MessageDigest;


/**
 * MD5加密密码
 */
public class PasswordMD5Encode {

    public static String pwdMD5Encode(String password){
        try{
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            BASE64Encoder base64Encoder = new BASE64Encoder();
            String pwd = base64Encoder.encode(md5.digest(password.getBytes("utf-8")));
            return pwd;
        } catch (Exception e){
            e.getMessage();
        }
        return null;
    }
}
