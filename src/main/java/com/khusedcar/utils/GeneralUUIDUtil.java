package com.khusedcar.utils;

import java.util.UUID;

/**
 * UUID生成工具类
 */
public class GeneralUUIDUtil {


    /**
     * 生成用户ID
     * @return
     */
    public static String uuidEncodeUserId(){
        return UUID.randomUUID().toString().replace("-","");
    }

    /**
     * 生成邀请码
     * @return
     */
    public static String uuidEncodeKey(){
        return UUID.randomUUID().toString();
    }

    /**
     * 生成合同ID
     * @return
     */
    public static String uuidEncodeContractId(){
        return UUID.randomUUID().toString();
    }
}
