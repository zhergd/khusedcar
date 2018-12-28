package com.khusedcar.utils.enums;


import lombok.Getter;

/**
 * 返回码枚举类
 */
@Getter
public enum ResultEnums {

    SUCCESS("0000","成功"),
    LOGIN_FAILED("0001","用户名或密码不正确"),
    REGISTYFAILED("0002","账号已存在"),

    /** 待办事项错误返回枚举 */
    NEW_SCHEDULE_ERROR("0011","新增待办事项失败"),
    SCHEDULE_ERROR("0012","待办事项不存在"),

    /** 用户枚举对象 */
    USER_UPDATA_ERROR("0021","用户信息更改失败"),
    USER_UPPASSWORD_ERROR("0022","密码更改失败"),
    USER_FIND_ERROR("0023","查询用户失败"),
    USER_DELECT_ERROR("0024","锁定用户失败"),
    USER_NEWKEY_ERROR("0025","生成邀请码失败"),
    USER_UPKEY_ERROR("0026","邀请码填写错误"),
    USER_RETRIEVE_ERROR("0027","重置密码失败"),
    USER_FINDKEY_ERROR("0028","查询邀请码失败"),


    /** 待办事务枚举对象 */
    SCHEDULE_FIND_ERROR("0030","查询待办事务失败"),
    SCHEDULE_ADD_ERROR("0031","新增待办事务失败"),
    SCHEDULE_FINISH_ERROR("0032","待办事务完成失败"),
    SCHEDULE_DELETE_ERROR("0033","删除待办事务失败"),

    /** 车源管理枚举对象 */
    CAR_FINDALL_ERROR("0040","查询车辆失败"),
    CAR_FINDBY_ERROR("0041","查询车辆失败"),
    CAR_ADD_ERROR("0042","车辆上报失败"),
    CAR_FINISH_ERROR("0043","车辆成交失败"),
    CAR_DELETE_ERROR("0044","车辆删除失败"),
    CAR_LOCKING_ERROR("0045","车辆锁定失败"),


    /** 管理员枚举对象 */
    ADMIN_ADDTINSURANCE_ERROR("0050","新增保险项目失败"),
    ADMIN_FINDTINSURANCE_ERROR("0051","查询保险项目失败"),
    ADMIN_DELETETINSURANCE_ERROR("0052","删除保险项目失败"),
    ADMIN_ADDTMAINTAIN_ERROR("0053","新增保养项目失败"),
    ADMIN_FINDTMAINTAIN_ERROR("0054","查询保养项目失败"),
    ADMIN_DELETETMAINTAIN_ERROR("0055","删除保养项目失败"),
    ADMIN_RECORD_ERROR("0056","查看操作记录失败"),
    ADMIN_RECOVERY_ERROR("0057","恢复失败"),









    ;

    private String code;
    private String msg;


    ResultEnums(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
