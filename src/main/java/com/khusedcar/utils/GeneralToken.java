package com.khusedcar.utils;


import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 登陆token生成类
 */
public class GeneralToken {


    public static String getToken(String loginName){
        //登陆名+当前时间戳
        String token = loginName + System.currentTimeMillis();
        //把token变为字节数组后，使用md5算法
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("md5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        byte[] digest = md5.digest(token.getBytes());
        //把字节数组用base64构建字符串返回
        BASE64Encoder base64Encoder = new BASE64Encoder();
        return base64Encoder.encode(digest);
    }
}
