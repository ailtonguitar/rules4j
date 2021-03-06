package com.rules4j.helpers;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class ObjectHelper {

	public static Map<String, Object> toMap(Object data){
		Map<String, Object> map = new HashMap<String, Object>();		
		try {
			putValues(data, map);
		} catch (IllegalAccessException e) {
			return map;
		}		
		return map;
	}

	private static void putValues(Object bean, Map<String, Object> map) throws IllegalAccessException {
		Class<?> cls = bean.getClass();

		for (Field field : cls.getDeclaredFields()) {
			field.setAccessible(true);
			Object value = field.get(bean);
			String key = field.getName();
			map.put(key, value);
		}
	}
}
