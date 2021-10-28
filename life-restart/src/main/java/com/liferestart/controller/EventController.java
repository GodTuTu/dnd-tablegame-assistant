package com.liferestart.controller;

import com.dnd.base.api.response.Result;
import com.liferestart.entity.AttributeValue;
import com.liferestart.entity.form.response.EventResponse;
import com.liferestart.entity.po.Event;
import com.liferestart.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("event")
public class EventController {
    @Autowired
    private EventService eventService;

    @PostMapping("/query")
    public Result<EventResponse> query(@RequestBody AttributeValue value) {
        return Result.succeed(eventService.query(value));
    }

    @PostMapping("/add")
    public Result add(@RequestBody Event event) {
        return Result.succeed(eventService.add(event));
    }

    @PostMapping("/addBatch")
    public Result addBatch(@RequestBody List<Event> event) {
        return Result.succeed(eventService.addBatch(event));
    }
}
