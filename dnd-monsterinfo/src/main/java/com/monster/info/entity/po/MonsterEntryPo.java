package com.monster.info.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.dnd.base.api.elitem.ELItem;
import lombok.Data;

import java.io.Serializable;

/**
 * 怪物条目
 */
@Data
@TableName("tb_monster_entry")
public class MonsterEntryPo extends ELItem implements Serializable {
    /**
     * 名字
     */
    private String name;
    /**
     * 英文名
     */
    private String englishName;
    /**
     * 气候
     */
    private Integer climate;
    /**
     * 地形
     */
    private Integer terrain;
    /**
     * 出现频率
     */
    private Integer frequency;
    /**
     * 组织类型
     */
    private String orgType;

    /**
     * 活动周期
     */
    private String activityCycle;
    /**
     * 食性
     */
    private Integer diet;

    /**
     * max智力
     */
    private Integer maxIntelligence;
    /**
     * min智力
     */
    private Integer minIntelligence;
    /**
     * 宝藏level
     */
    private String treasureLevel;
    /**
     * 阵营
     */
    private Integer alignment;
    /**
     * max数量
     */
    private Integer maxNum;

    /**
     * min数量
     */
    private Integer minNum;
    /**
     * 防御等级
     */
    private Integer defenseLevel;
    /**
     * 移动速度
     */
    private Integer speed;
    /**
     * 移动方式
     */
    private Integer movement;
    /**
     * 生命骰
     */
    private String lifeDice;
    /**
     * 零级命中值
     */
    private Integer hitZero;
    /**
     * 每轮攻击次数
     */
    private Integer attackNum;

    /**
     * 体型
     */
    private Integer size;
    /**
     * 士气
     */
    private Integer morale;
    /**
     * 经验回报
     */
    private Integer experience;
    /**
     * 备注1--战斗描述,移动方式
     */
    private String remark1;
    /**
     * 备注2--其他信息
     */
    private String remark2;
}
