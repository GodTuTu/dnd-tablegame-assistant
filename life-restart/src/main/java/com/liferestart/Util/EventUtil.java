package com.liferestart.Util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.liferestart.entity.AttributeValue;
import com.liferestart.entity.EventLog;
import com.liferestart.entity.constant.DiceConstant;
import com.liferestart.entity.constant.RequestConstant;
import com.liferestart.entity.enums.DictionaryConfigKeyEnum;
import com.liferestart.entity.enums.DictionaryEnum;
import com.liferestart.entity.form.response.EventResponse;
import com.liferestart.entity.po.Event;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Random;

/**
 * 事件工具类
 */
public class EventUtil {

    /**
     * 生成事件
     *
     * @param value 当前属性对象
     * @return 事件code
     */
    public static String creatEvent(AttributeValue value) {
        //获取随机数
        Integer eventDiceP = DiceUtil.randomDice(DiceConstant.EVENT_RARITY);
        //System.out.println(eventDiceP);
        String eventRaryCode = "";
        //判断概率code
        if (eventDiceP < DictionaryEnum.EVENT_RARITY_UNIQUE.getNumber()) {
            eventRaryCode = DictionaryEnum.EVENT_RARITY_UNIQUE.getValue();
        } else if (eventDiceP < DictionaryEnum.EVENT_RARITY_RARE.getNumber()) {
            eventRaryCode = DictionaryEnum.EVENT_RARITY_RARE.getValue();

        } else if (eventDiceP < DictionaryEnum.EVENT_RARITY_COMMON.getNumber()) {
            eventRaryCode = DictionaryEnum.EVENT_RARITY_COMMON.getValue();

        } else {
            eventRaryCode = DictionaryEnum.EVENT_RARITY_NOMAL.getValue();
        }
        //获取具体事件code
        eventRaryCode = eventRaryCode + DiceConstant.EVENT;
        value.setTypeCode(eventRaryCode);
        EventResponse response = new EventResponse();
        String resultEvent = HttpRequest.sendPost(RequestConstant.CREAT_EVENT, value);

        ObjectMapper mapper = new ObjectMapper();

        //将返回的result包装的response转化为对象
        int index = resultEvent.indexOf("{");
        resultEvent = resultEvent.substring(resultEvent.indexOf("{", index + 1), resultEvent.indexOf("}") + 1);
        try {
            response = mapper.readValue(resultEvent, EventResponse.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response.getEventName();
    }

    public static void eventPrint(EventResponse response, AttributeValue value) {

        Class classType = response.getClass();

        Field fields[] = classType.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field f = fields[i];
            f.setAccessible(true);
            try {
                String fieldName = DictionaryConfigKeyEnum.getEnum(f.getName().toString()).getRemark();
//                System.out.println(f.getName().toString());
//                System.out.println(f.getType().toString());
//                System.out.println(fieldName);
                String isAdd = "";
                Integer data = (Integer) f.get(response);
                if (data > 0) {
                    isAdd = "增加";
                } else if (data < 0) {
                    isAdd = "减少";
                } else {
                    continue;
                }
                System.out.println(fieldName+isAdd+Math.abs(data));
            } catch (NullPointerException e) {
                continue;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public static List<EventLog> eventLog(EventResponse response, List<EventLog> logs) {
        for (EventLog log : logs) {
            if (log.getEventCode().equals(response.getEventCode()) && log.getIsRepeat() == 0) {
                return null;
            } else {
                continue;
            }
        }
        return logs;
    }
}
