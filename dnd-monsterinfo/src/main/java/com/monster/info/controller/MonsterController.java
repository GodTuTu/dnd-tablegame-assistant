package com.monster.info.controller;

import com.dnd.base.api.response.Result;
import com.monster.info.entity.po.MonsterEntryPo;
import com.monster.info.service.MonsterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("monster")
@Api(tags = "【条目信息】怪物信息")
public class MonsterController {
    @Autowired
    private MonsterService monsterService;

    @ApiOperation(value = "新增条目", notes = "新增条目", httpMethod = "POST")
    @PostMapping("/addMonsterEntry")
    public Result addEntry(@RequestBody MonsterEntryPo monsterEntryPo){
        return Result.succeed();
    }
}
