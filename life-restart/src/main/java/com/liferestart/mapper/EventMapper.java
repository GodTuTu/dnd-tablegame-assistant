package com.liferestart.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liferestart.entity.AttributeValue;
import com.liferestart.entity.form.response.EventResponse;
import com.liferestart.entity.po.Event;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventMapper extends BaseMapper<Event> {
    @Select("select id from tb_event")
    Event selectTest();

    List<EventResponse> query(AttributeValue value);
}
