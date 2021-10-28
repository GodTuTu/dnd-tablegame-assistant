package com.liferestart.entity.constant;

import lombok.Data;

@Data
public class DiceConstant {
    /** 骰子类型 **/
    public static final Integer EVENT_RARITY =100;//事件稀有度骰子
    public static final Integer INITIAL_NOMAL_VALUE = 10;//初始普通属性骰子
    public static final Integer INITIAL_SPECIAL_VALUE = 5;//初始特殊属性骰子
    /** 字典拼接字段 **/
    public static final String EVENT="_EVENT";
}
