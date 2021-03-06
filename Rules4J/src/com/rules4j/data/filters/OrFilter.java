package com.rules4j.data.filters;

import java.util.Map;

import com.rules4j.data.IRule;

public class OrFilter extends Filter {
	
	public OrFilter(IRule rule) {
		super(rule);
	}

	@Override
	public boolean evaluate(Map<String, Object> data) {
        return this.getConstraints().stream().anyMatch(c -> c.evaluate(data));
	}
}
