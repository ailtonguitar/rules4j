package com.rules4j.data.constraints;

import java.util.Map;

public class EqualsConstraint implements IConstraint {
	private String property;
	private Object value;

	public EqualsConstraint(String property, Object value) {
		this.property = property;
		this.value = value;
	}

	@Override
	public boolean evaluate(Map<String, Object> data) {
		if (!data.containsKey(this.property))
			return false;

		String currentValue = (String)data.get(property);
		
		if(currentValue == null)
			return false;
		
		return currentValue.equalsIgnoreCase(value.toString());
	}

}
