package com.liferestart.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.liferestart.entity.AttributeValue;
import com.liferestart.entity.form.response.EventResponse;
import com.liferestart.entity.po.Event;

import java.util.List;

public interface EventService extends IService<Event> {
    EventResponse query(AttributeValue value);

    Boolean add(Event event);

    Boolean addBatch(List<Event> events);
}
