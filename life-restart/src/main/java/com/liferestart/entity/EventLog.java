package com.liferestart.entity;

import lombok.Data;

@Data
/**
 * 记录一局事件
 */
public class EventLog {
    /**
     * 事件code
     */
    private String eventCode;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 是否可以重复
     */
    private Integer isRepeat;
}
