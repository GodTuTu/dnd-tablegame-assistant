package com.monster.info.entity.enums;


/**
 * 字典键值枚举枚举<br>
 * 配合枚举 DictionaryEnum<br><br>
 * 字典Key值通过下划线分段设计，包含隐式父子结构，例如：<br>
 * key_A, key_B是key的子键，<br>
 *   通过key可以查到所有键值为key、key_A、key_B的字典枚举，<br>
 *   通过key_A仅能查到键值为key_A的字典枚举，同理，key_B仅能查到key_B的字典枚举。<br>
 */
public enum DictionaryConfigKeyEnum {
	/** 通用 **/
	EMPTY_ENTITY("EMPTY_ENTITY", "未指定实体"),
	//怪物信息
	CLIMATE("CLIMATE","气候"),
	FREQUENCY("FREQUENCY","出现频率"),
	TERRAIN("TERRAIN","地形"),
	DIET("DIET","食性")
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
