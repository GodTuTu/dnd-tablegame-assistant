package com.monster.info.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.monster.info.entity.po.MonsterEntryPo;
import org.springframework.stereotype.Repository;

@Repository
public interface MonsterMapper extends BaseMapper<MonsterEntryPo> {
}
