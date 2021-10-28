package com.monster.info.entity.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * 字典枚举<br>
 * 替代字典表sys_dictionary
 */
public enum DictionaryEnum {
	// 无对应
	DEFAULT("DEFAULT", "-","未能找到对应字典"),
	//EDITION_BUILD_STATUS_1(DictionaryConfigKeyEnum.BUILD_STATUS.getKey(),"1","未构建")
	//怪物信息 1d100
	FREQUENCY_1(DictionaryConfigKeyEnum.FREQUENCY.getKey(),"1","非常罕见",4),
	FREQUENCY_2(DictionaryConfigKeyEnum.FREQUENCY.getKey(),"2","罕见",11),
	FREQUENCY_3(DictionaryConfigKeyEnum.FREQUENCY.getKey(),"3","不常见",20),
	FREQUENCY_4(DictionaryConfigKeyEnum.FREQUENCY.getKey(),"4","常见",65),

	TERRAIN_1(DictionaryConfigKeyEnum.TERRAIN.getKey(), "1","平原"),
	TERRAIN_1_1(DictionaryConfigKeyEnum.TERRAIN.getKey(), "2","灌木丛"),
	TERRAIN_2(DictionaryConfigKeyEnum.TERRAIN.getKey(), "3","森林"),
	TERRAIN_3(DictionaryConfigKeyEnum.TERRAIN.getKey(), "4","丘陵"),
	TERRAIN_3_1(DictionaryConfigKeyEnum.TERRAIN.getKey(), "5","高地"),
	TERRAIN_4(DictionaryConfigKeyEnum.TERRAIN.getKey(), "6","山岳"),
	TERRAIN_5(DictionaryConfigKeyEnum.TERRAIN.getKey(), "7","沼泽"),
	TERRAIN_6(DictionaryConfigKeyEnum.TERRAIN.getKey(), "8","沙漠"),

	DIET_1(DictionaryConfigKeyEnum.DIET.getKey(), "1","草食"),
	DIET_2(DictionaryConfigKeyEnum.DIET.getKey(), "2","肉食"),
	DIET_3(DictionaryConfigKeyEnum.DIET.getKey(), "3","杂食"),
	DIET_4(DictionaryConfigKeyEnum.DIET.getKey(), "4","食腐"),

	CLIMATE_1(DictionaryConfigKeyEnum.CLIMATE.getKey(), "1","寒带"),
	CLIMATE_2(DictionaryConfigKeyEnum.CLIMATE.getKey(), "2","亚寒带"),
	CLIMATE_3(DictionaryConfigKeyEnum.CLIMATE.getKey(), "3","温带"),
	CLIMATE_4(DictionaryConfigKeyEnum.CLIMATE.getKey(), "4","热带")


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
