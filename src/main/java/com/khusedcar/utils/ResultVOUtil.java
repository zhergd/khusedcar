package com.khusedcar.utils;


import com.khusedcar.utils.enums.ResultEnums;

import java.util.ArrayList;

/**
 * 组装返回报文格式
 */
public class ResultVOUtil {

    /**
     * 有数据的返回成功报文
     * @param object  数据对象
     * @return
     */
    public static ResultVO success(Object object, ResultEnums resultEnums){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(resultEnums.getCode());
        resultVO.setData(object == null ? new ArrayList<>() : object);
        resultVO.setMsg(resultEnums.getMsg());
        return resultVO;
    }


    /**
     * 返回失败报文
     * @param resultEnums  枚举对象
     * @return
     */
    public static ResultVO failed(ResultEnums resultEnums){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(resultEnums.getCode());
        resultVO.setMsg(resultEnums.getMsg());
        resultVO.setData(new ArrayList<>());
        return resultVO;
    }
}
