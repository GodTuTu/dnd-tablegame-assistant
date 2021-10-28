package com.monster.info.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.dnd.base.api.elitem.ELItem;
import lombok.Data;

import java.io.Serializable;

/**
 * 装备条目
 */
@Data
@TableName("tb_equipment")
public class EquipmentEntryPo extends ELItem implements Serializable {
}
