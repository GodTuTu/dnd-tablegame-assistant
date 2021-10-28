package com.liferestart;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liferestart.Util.*;
import com.liferestart.entity.AttributeValue;
import com.liferestart.entity.constant.DiceConstant;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.liferestart.entity.constant.RequestConstant;
import com.liferestart.entity.form.response.EventResponse;
import com.liferestart.entity.po.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

public class LocatStart {

    public static void main(String[] args) throws Exception {
        //start();
        EventResponse response = new EventResponse();
        response.setId(1);
        response.setLuck(1);
        response.setCharm(-1);
        AttributeValue value = new AttributeValue();
        EventUtil.eventPrint(response,value);

    }

    /**
     * 生成出生属性
     *
     * @return
     */
    public static AttributeValue life(AttributeValue value) {
        Scanner input = new Scanner(System.in);
        Integer diceA, diceB, diceC, diceD, sumDice, health, familyCircumstances, intell, charm;
        diceA = DiceUtil.randomDice(1, DiceConstant.INITIAL_NOMAL_VALUE);
        diceB = DiceUtil.randomDice(1, DiceConstant.INITIAL_NOMAL_VALUE);
        diceC = DiceUtil.randomDice(1, DiceConstant.INITIAL_NOMAL_VALUE);
        diceD = DiceUtil.randomDice(1, DiceConstant.INITIAL_SPECIAL_VALUE);
        sumDice = diceA + diceB + diceC + diceD;
        System.out.println("你一共得到了:" + sumDice + "点属性点");
        while (true) {
            charm = distributionAtti("魅力", false);
            intell = distributionAtti("智力", true);
            familyCircumstances = distributionAtti("家境", true);
            health = distributionAtti("健康", true);
            if (charm + intell + familyCircumstances + health > sumDice) {
                System.out.println("总数超了,请重新填写");
            } else if (charm + intell + familyCircumstances + health < sumDice) {
                System.out.println("你还有剩的,就这样吗?输入(Y/N)");
                String t = input.next();
                if (t.equals("Y")) {
                    break;
                }
            } else {
                break;
            }
        }
        value.setHealth(health);
        value.setFamilyCircumstances(familyCircumstances);
        value.setIntelligence(intell);
        value.setCharm(charm);
        value.setSocial(0);
        value.setMood(0);
        value.setLife(0);
        value.setStrength(0);
        value.setLuck(DiceUtil.randomDice(1, DiceConstant.INITIAL_SPECIAL_VALUE));
        value.setAge(0);
        value.setIsAlive(true);
        return value;
    }

    /**
     * 手动加点
     */
    public static Integer distributionAtti(String name, Boolean isNomal) {
        Scanner input = new Scanner(System.in);
        Integer data;
        Integer nomalData;
        if (isNomal) {
            nomalData = DiceConstant.INITIAL_NOMAL_VALUE;
        } else {
            nomalData = DiceConstant.INITIAL_SPECIAL_VALUE;
        }
        System.out.println("现在给你的" + name + "分配,请注意最大不能超过:" + nomalData + ",最小值不能小于1");
        while (true) {
            data = input.nextInt();
            if (data <= nomalData && data > 0) {
                break;
            } else {
                System.out.println("输入不对,请注意最大不能超过:" + nomalData + ",最小值不能小于1");
            }
        }
        return data;
    }

    public static void printAtti(AttributeValue value) {
        System.out.println("你的健康为:" + value.getHealth());
        System.out.println("你的家境为:" + value.getFamilyCircumstances());
        System.out.println("你的智力为:" + value.getIntelligence());
        System.out.println("你的魅力为:" + value.getCharm());
        System.out.println("你的幸运为:" + value.getLuck());
        System.out.println("你的力量为:" + value.getStrength());
    }

    /**
     * 启动器
     */
    private static void start() {
        AttributeValue value = new AttributeValue();
        value.setAge(0);
        life(value);
        printAtti(value);
        AttributeUtil.getLife(value);
        while (true) {
            Scanner input = new Scanner(System.in);
            System.out.println("你" + value.getAge() + "岁了");
            System.out.println(EventUtil.creatEvent(value));
            //input.hasNextLine();
            value.setAge(value.getAge() + 1);
            AttributeUtil.getStrength(value);
            if (value.getAge().equals(value.getLife())) {
                break;
            }
        }
        printAtti(value);
        System.out.println("你死了");
    }

}

