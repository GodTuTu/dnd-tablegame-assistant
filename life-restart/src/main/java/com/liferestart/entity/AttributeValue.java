package com.liferestart.entity;

import lombok.Data;

@Data
/**
 * 属性值
 */
public class AttributeValue {
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 是否存活
     */
    private Boolean isAlive;
    /**
     * 心情
     */
    private Integer mood;
    /**
     * 寿命
     */
    private Integer life;
    /**
     * 健康
     */
    private Integer health;
    /**
     * 力量
     */
    private Integer strength;
    /**
     * 家境
     */
    private Integer familyCircumstances;
    /**
     * 财富
     */
    private Integer wealth;
    /**
     * 智力
     */
    private Integer intelligence;
    /**
     * 魅力
     */
    private Integer charm;
    /**
     * 社交
     */
    private Integer social;
    /**
     * 幸运
     */
    private Integer luck;
    /**
     * 阵营(补充值)
     */
    private Integer camp;
    /**
     * 生成事件稀有度
     */
    private String typeCode;
}
