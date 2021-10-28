package com.liferestart.Util;

import com.liferestart.entity.AttributeValue;

/**
 * 属性与游戏
 */
public class AttributeUtil {
    /**
     * 寿命
     * 初始健康标准 d10
     * 1  身体有缺
     * 2  脆弱
     * 3  萎靡
     * 4  虚弱
     * 5  正常
     * 6  正常
     * 7  健康
     * 8  很健康
     * 9  百病不侵
     * 10 长寿
     */
    public static AttributeValue getLife(AttributeValue value) {
        Integer diceNum = 0;
        switch (value.getHealth()) {
            case 1:
                diceNum = 1;
                break;
            case 2:
                diceNum = 2;
                break;
            case 3:
                diceNum = 3;
                break;
            case 4:
                diceNum = 4;
                break;
            case 5:
                diceNum = 6;
                break;
            case 6:
                diceNum = 6;
                break;
            case 7:
                diceNum = 7;
                break;
            case 8:
                diceNum = 8;
                break;
            case 9:
                diceNum = 9;
                break;
            case 10:
                diceNum = 10;
                break;
        }
        for (int i = 0; i < diceNum; i++) {
            Integer a = DiceUtil.randomDice(1, 10);
            System.out.println(a);
            value.setLife(value.getLife() + a);
        }
        value.setLife(value.getLife() + DiceUtil.randomDice(10, 20));
        System.out.println("寿命:" + value.getLife());
        return value;
    }

    /**
     * 生成力量 每回合根据健康给力量补充值
     * 1  身体有缺  18岁之前 每回合+[1,2] 之后每回合[-2]
     * 2  脆弱    18岁之前 每回合+[1,3] 之后每回合[-2]
     * 3  萎靡    18岁之前 每回合+[1,3] 之后每回合[-1]
     * 4  虚弱    age/2岁之前 每回合+[1,3]
     * 5  正常    age/2岁之前 每回合+[2,3]
     * 6  正常    age/2岁之前 每回合+[2,3]
     * 7  健康    age/2岁之前 每回合+[2,4]
     * 8  很健康   age/2岁之前 每回合+[2,4]
     * 9  百病不侵 age/2岁之前 每回合+[2,5]
     * 10 长寿    age/2岁之前 每回合+[3,5]
     */
    public static AttributeValue getStrength(AttributeValue value) {
        Integer maxDiceNum, minDiceNum;
        switch (value.getHealth()) {
            case 1:
                minDiceNum = 1;
                maxDiceNum = 2;
                if (value.getAge()<=18){
                    value.setStrength(value.getStrength()+DiceUtil.randomDice(minDiceNum,maxDiceNum));
                }else {
                    value.setStrength(value.getStrength()-2);
                }
                break;
            case 2:
                minDiceNum = 1;
                maxDiceNum = 3;
                if (value.getAge()<=18){
                    value.setStrength(value.getStrength()+DiceUtil.randomDice(minDiceNum,maxDiceNum));
                }else {
                    value.setStrength(value.getStrength()-2);
                }
                break;
            case 3:
                minDiceNum = 1;
                maxDiceNum = 3;
                if (value.getAge()<=18){
                    value.setStrength(value.getStrength()+DiceUtil.randomDice(minDiceNum,maxDiceNum));
                }else {
                    value.setStrength(value.getStrength()-1);
                }
                break;
            case 4:
                minDiceNum = 1;
                maxDiceNum = 3;
                if (value.getAge()<=(value.getLife()/2)){
                    value.setStrength(value.getStrength()+DiceUtil.randomDice(minDiceNum,maxDiceNum));
                }else {
                    value.setStrength(value.getStrength()-1);
                }
                break;
            case 5:
            case 6:
                minDiceNum = 2;
                maxDiceNum = 3;
                if (value.getAge()<=(value.getLife()/2)){
                    value.setStrength(value.getStrength()+DiceUtil.randomDice(minDiceNum,maxDiceNum));
                }else {
                    value.setStrength(value.getStrength()-1);
                }
                break;
            case 7:
            case 8:
                minDiceNum = 2;
                maxDiceNum = 4;
                if (value.getAge()<=(value.getLife()/2)){
                    value.setStrength(value.getStrength()+DiceUtil.randomDice(minDiceNum,maxDiceNum));
                }else {
                    value.setStrength(value.getStrength()-1);
                }
                break;
            case 9:
                minDiceNum = 2;
                maxDiceNum = 5;
                if (value.getAge()<=(value.getLife()/2)){
                    value.setStrength(value.getStrength()+DiceUtil.randomDice(minDiceNum,maxDiceNum));
                }else {
                    value.setStrength(value.getStrength()-1);
                }
                break;
            case 10:
                minDiceNum = 3;
                maxDiceNum = 5;
                if (value.getAge()<=(value.getLife()/2)){
                    value.setStrength(value.getStrength()+DiceUtil.randomDice(minDiceNum,maxDiceNum));
                }else {
                    value.setStrength(value.getStrength()-1);
                }
                break;
        }
        return value;
    }
}
