package com.monster.info.controller;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.monster.info.entity.constant.FieldConstant;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

/**
 * @author along
 * mybatisplus配置
 */
@Configuration
public class MybatisPlusConfig implements MetaObjectHandler {


    @Override
    public void insertFill(MetaObject metaObject) {
        if (metaObject.hasGetter(FieldConstant.CREATE_TIME) &&
                metaObject.hasGetter(FieldConstant.UPDATE_TIME)) {
            setFieldValByName(FieldConstant.CREATE_TIME, new Date(), metaObject);
            setFieldValByName(FieldConstant.UPDATE_TIME, new Date(), metaObject);
        }
        // todo 创建人更新人
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        if (metaObject.hasGetter(FieldConstant.UPDATE_TIME)) {
            setFieldValByName(FieldConstant.UPDATE_TIME, new Date(), metaObject);
        }
    }
}
