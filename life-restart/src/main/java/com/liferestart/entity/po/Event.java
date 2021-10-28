package com.liferestart.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.liferestart.entity.enums.ELItem;
import lombok.Data;

@Data
@TableName("tb_event")
public class Event extends ELItem {
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
     *最大年龄
     */
    private Integer maxAge;
    /**
     *最小年龄
     */
    private Integer minAge;
    /**
     *最大心情
     */
    private Integer minMood;
    /**
     *最小心情
     */
    private Integer maxMood;
    /**
     *最大健康
     */
    private Integer maxHealth;
    /**
     *最小健康
     */
    private Integer minHealth;
    /**
     *最大力量
     */
    private Integer maxStrength;
    /**
     *最小力量
     */
    private Integer minStrength;
    /**
     *最大财富
     */
    private Integer maxWealth;
    /**
     *最小财富
     */
    private Integer minWealth;
    /**
     *最大家境
     */
    private Integer maxFamilyCircumstances;
    /**
     *最小家境
     */
    private Integer minFamilyCircumstances;
    /**
     *最大智力
     */
    private Integer maxIntelligence;
    /**
     *最小智力
     */
    private Integer minIntelligence;
    /**
     *最大魅力
     */
    private Integer maxCharm;
    /**
     *最小魅力
     */
    private Integer minCharm;
    /**
     *最大社交
     */
    private Integer maxSocial;
    /**
     *最小社交
     */
    private Integer minSocial;
    /**
     *最大幸运
     */
    private Integer maxLuck;
    /**
     *最小幸运
     */
    private Integer minLuck;
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
