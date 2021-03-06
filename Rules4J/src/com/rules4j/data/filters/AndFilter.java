package com.rules4j.data.filters;

import java.util.Map;

import com.rules4j.data.IRule;

public class AndFilter extends Filter {
	
	public AndFilter(IRule rule) {
		super(rule);
	}

	@Override
	public boolean evaluate(Map<String, Object> data) {
        return this.getConstraints().stream().allMatch(c -> c.evaluate(data));
	}
}
