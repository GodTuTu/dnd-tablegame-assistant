package com.liferestart.entity.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * 字典枚举<br>
 * 替代字典表sys_dictionary
 */
public enum DictionaryEnum {
	/**
	 * 事件稀有度
	 */
	EVENT_RARITY_NOMAL(DictionaryConfigKeyEnum.EVENT_RARITY.getKey(), "NOMAL","普通",100),
	EVENT_RARITY_COMMON(DictionaryConfigKeyEnum.EVENT_RARITY.getKey(), "COMMON","常见",40),
	EVENT_RARITY_RARE(DictionaryConfigKeyEnum.EVENT_RARITY.getKey(), "RARE","罕见",10),
	EVENT_RARITY_UNIQUE(DictionaryConfigKeyEnum.EVENT_RARITY.getKey(), "UNIQUE","绝无仅有",1),

	//事件code生成 稀有度_事件名(拼音首字母缩写)_是否可重复y/n  例如 nomal_tksfh_y
	/** 普通事件 **/
	NOMAL_EVENT_1(DictionaryConfigKeyEnum.NOMAL_EVENT.getKey(), "1","土克松访华,跟你没啥关系"),

	/** 常见事件**/
	COMMON_EVENT_1(DictionaryConfigKeyEnum.COMMON_EVENT.getKey(), "1","邻居结婚,你抢了五块钱红包"),

	/** 罕见事件**/
	RARE_EVENT_1(DictionaryConfigKeyEnum.RARE_EVENT.getKey(), "1","爸妈吵架闹离婚"),

	/** 稀有事件**/
	UNIQUE_EVENT_1(DictionaryConfigKeyEnum.UNIQUE_EVENT.getKey(), "1","彩票中奖"),
	// 无对应
	DEFAULT("DEFAULT", "-","未能找到对应字典")
	;


	private String key;
	private String value;
	private String name;
	private Integer number;

	DictionaryEnum(String key, String value, String name) {
		this.key = key;
		this.name = name;
		this.value = value;
		this.number = null;
	}
	
	DictionaryEnum(String key, String value, String name, Integer number) {
		this.key = key;
		this.name = name;
		this.value = value;
		this.number = number;
	}
	
	/** 判断枚举的值等于指定值 **/
	public Boolean equals(String value) {
		return this.getValue().equals(value);
	}
	/** 判断枚举等于指定枚举 **/
	public Boolean equals(DictionaryEnum e) {
		return this.getValue().equals(e.getValue()) && this.getKey().equals(e.getKey());
	}

	/** 根据parm模糊翻译 value-name **/
	public static String getName(String key, String value) {
		if (value != null) {
			for (DictionaryEnum f : DictionaryEnum.values()) {
				if (f.getKey().startsWith(key) && f.getValue().equalsIgnoreCase(value)) {
					return f.getName();
				}
			}
		}
		return null;
	}
	
	/** 根据parm模糊翻译 name-value **/
	public static String getValue(String key, String name) {
		if (name != null) {
			for (DictionaryEnum f : DictionaryEnum.values()) {
				if (f.getKey().startsWith(key) && f.getName().equals(name)) {
					return f.getValue();
				}
			}
		}
		return null;
	}
	
	public static DictionaryEnum getDictionaryEnum(String key, String value) {
		for (DictionaryEnum f : DictionaryEnum.values()) {
			if (f.getKey().startsWith(key) && f.getValue().equalsIgnoreCase(value)) {
				return f;
			}
		}
		return DEFAULT;
	}
	
	/** 根据parm模糊查找 */
	public static List<DictionaryEnum> getEnumList(String parm) {
		List<DictionaryEnum> list = new ArrayList<DictionaryEnum>();
		for (DictionaryEnum f : DictionaryEnum.values()) {
			if (f.getKey().startsWith(parm)) {
				list.add(f);
			}
		}
		return list;
	}
	
	/** 根据parm模糊查找, 并拼接成SQL条件 */
	public static String getEnumValueSQL(String parm) {
		String sql = "";
		for (DictionaryEnum f : DictionaryEnum.values()) {
			if (f.getKey().startsWith(parm)) {
				sql += ",'" + f.getValue() + "'";
			}
		}
		if (sql.length() > 0) {
			sql = sql.substring(1);
		}
		return sql;
	}
	
	/** 根据parm模糊查找, 并返回List<value> */
	public static List<String> getEnumValueList(String parm) {
		List<String> valueList = new ArrayList<String>();
		for (DictionaryEnum f : DictionaryEnum.values()) {
			if (f.getKey().startsWith(parm)) {
				valueList.add(f.getValue());
			}
		}
		return valueList;
	}
	
	/** 根据parm模糊查找, 并返回List<name> */
	public static List<String> getEnumNameList(String parm) {
		List<String> valueList = new ArrayList<String>();
		for (DictionaryEnum f : DictionaryEnum.values()) {
			if (f.getKey().startsWith(parm)) {
				valueList.add(f.getName());
			}
		}
		return valueList;
	}

	public String getKey() {
		return key;
	}

	public String getName() {
		return name;
	}
	
	public String getValue() {
		return value;
	}
	
	public Integer getNumber() {
		return number;
	}
}
