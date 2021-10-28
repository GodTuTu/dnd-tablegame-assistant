package com.liferestart.entity.enums;


/**
 * 字典键值枚举枚举<br>
 * 配合枚举 DictionaryEnum<br><br>
 * 字典Key值通过下划线分段设计，包含隐式父子结构，例如：<br>
 * key_A, key_B是key的子键，<br>
 *   通过key可以查到所有键值为key、key_A、key_B的字典枚举，<br>
 *   通过key_A仅能查到键值为key_A的字典枚举，同理，key_B仅能查到key_B的字典枚举。<br>
 */
public enum DictionaryConfigKeyEnum {
	/** 事件	 **/
	EVENT_RARITY("EVENT_RARITY","事件稀有度"),
	//稀有度
	NOMAL_EVENT("NOMAL_EVENT","普通事件"),
	COMMON_EVENT("COMMON_EVENT","常见事件"),
	RARE_EVENT("RARE_EVENT","稀有事件"),
	UNIQUE_EVENT("UNIQUE_EVENT","罕见事件"),
	//字段值
	LUCK("luck","幸运"),
	SOCIAL("social","社交"),
	CHARM("charm","魅力"),
	INTELLIGENCE("intelligence","智力"),
	WEALTH("wealth","财富"),
	FAMILY_CIRCUMSTANCES("familyCircumstances","家境"),
	STRENGTH("strength","力量"),
	HEALTH("health","健康"),
	LIFE("life","寿命"),
	MOOD("mood","心情"),
	/** 通用 **/
	EMPTY_ENTITY("EMPTY_ENTITY", "未指定实体")
	;

	private String key;
	private String remark;

	DictionaryConfigKeyEnum(String key, String remark) {
		this.key = key;
		this.remark = remark;
	}
	
	/**
	 * 根据key查找指定字典
	 */
	public static DictionaryConfigKeyEnum getEnum(String key) {
		for (DictionaryConfigKeyEnum f : DictionaryConfigKeyEnum.values()) {
			if (f.getKey().equalsIgnoreCase(key)) {
				return f;
			}
		}
		return null;
	}

	public String getKey() {
		return key;
	}
	
	public String getRemark() {
		return remark;
	}
}
