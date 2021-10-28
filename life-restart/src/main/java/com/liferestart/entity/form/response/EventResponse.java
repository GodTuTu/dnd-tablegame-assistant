package com.liferestart.entity.form.response;

import com.liferestart.aop.annotation.EventPrint;
import lombok.Data;

@Data
public class EventResponse {
    /**
     * ID
     */
    private Integer id;
    /**
     * 类型编号(稀有度)
     */
    private String typeCode;
    /**
     *是否可以重复
     */
    private Integer isRepeat;
    /**
     *事件编号
     */
    private String eventCode;
    /**
     *事件名称
     */
    private String eventName;
    /**
     *内容值
     */
    private String value;
    /**
     *备注
     */
    private String remark;
    /**
     *幸运
     */
    private Integer luck;
    /**
     *社交
     */
    private Integer social;
    /**
     *魅力
     */
    private Integer charm;
    /**
     *智力
     */
    private Integer intelligence;
    /**
     *财富
     */
    private Integer wealth;
    /**
     *家境
     */
    private Integer familyCircumstances;
    /**
     *力量
     */
    private Integer strength;
    /**
     *健康
     */
    private Integer health;
    /**
     *寿命
     */
    private Integer life;
    /**
     *心情
     */
    private Integer mood;
    /**
     *致死/起死回生
     */
    private Integer isAlive;
}
