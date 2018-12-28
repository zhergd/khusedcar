package com.khusedcar.utils.enums;


import lombok.Getter;

/**
 * 员工任职状态枚举
 */
@Getter
public enum UserStatusEnum {
    ON_THE_JOB(0, "在职"),
    DIMISSION(1,"离职");

    private Integer code;
    private String message;

    UserStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
