package com.khusedcar.utils;


/**
 * 返回信息对象
 * @param <T>
 */
public class ResultVO<T> {

    /** 返回码 */
    private String code;

    /** 返回信息 */
    private String msg;

    /** 返回数据 */
    private T data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
