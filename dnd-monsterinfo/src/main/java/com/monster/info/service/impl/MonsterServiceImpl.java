package com.monster.info.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.monster.info.service.MonsterService;
import com.monster.info.entity.po.MonsterEntryPo;
import com.monster.info.mapper.MonsterMapper;
import org.springframework.stereotype.Service;

@Service
public class MonsterServiceImpl extends ServiceImpl<MonsterMapper, MonsterEntryPo> implements MonsterService {
}
