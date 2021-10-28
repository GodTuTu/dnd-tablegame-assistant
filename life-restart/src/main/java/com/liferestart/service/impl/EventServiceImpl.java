package com.liferestart.service.impl;

import com.baomidou.mybatisplus.extension.api.Assert;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liferestart.entity.AttributeValue;
import com.liferestart.entity.constant.BizErrorConstant;
import com.liferestart.entity.enums.DictionaryEnum;
import com.liferestart.entity.form.response.EventResponse;
import com.liferestart.entity.po.Event;
import com.liferestart.mapper.EventMapper;
import com.liferestart.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;

@Service
public class EventServiceImpl extends ServiceImpl<EventMapper, Event> implements EventService {
    @Autowired
    private EventMapper eventMapper;

    @Override
    public EventResponse query(AttributeValue value) {
        List<EventResponse> responses = eventMapper.query(value);
        Assert.fail(null == responses, BizErrorConstant.EVENT_NULL);
        Random random = new Random();
        int n = random.nextInt(responses.size());
        EventResponse response = responses.get(n);
        return response;

    }
    @Override
    public Boolean add(Event event){
        return eventMapper.insert(event)>0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean addBatch(List<Event> events){
        for (Event event:events){
            add(event);
        }
        return true;
    }
}
