package com.xxx.brixton.common.entity;

import lombok.Data;

import java.util.Date;

/**
 * 实体类
 */
@Data
public class Entity {
    /**
     * 主键id
     */
    private Long id;

    /**
     * 字段a
     */
    private String fa;

    /**
     * 字段b
     */
    private Integer fb;

    /**
     * 字段c
     */
    private Date fc;
}
