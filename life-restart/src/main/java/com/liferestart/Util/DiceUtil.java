package com.liferestart.Util;

import java.util.Random;

/**
 * 骰子工具类
 */
public class DiceUtil {
    /**
     * 随机骰子
     * [0,maxDice)
     *
     * @param
     * @return 生成值
     */
    public static Integer randomDice(Integer maxDice) {
        Random rand = new Random();
        return rand.nextInt(maxDice);
    }

    /**
     * [minDice,maxDice]
     * 随机骰子
     * @param minDice
     * @param maxDice
     * @return
     */
    public static Integer randomDice(Integer minDice, Integer maxDice) {
        Random rand = new Random();
        Integer number = -1;
        while (true) {
            number = rand.nextInt(maxDice + 1);
            if (number >= minDice) {
                break;
            }
        }
        return number;
    }
}
