package com.khusedcar.schedule.entities;

import lombok.Data;

/**
 * 事务管理的实体类
 */
@Data
public class TSchedule {

    /**
     * 事务id
     */
    private Integer id;

    /**
     * 事务描述
     */
    private String scheduleDes;

    /**
     * 事务开始日期
     */
    private String scheduleDateBegin;

    /**
     * 事务结束日期
     */
    private String scheduleDateEnd;

    /**
     * 创建人id
     */
    private String salesmanId;

}