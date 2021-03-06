package com.rules4j.data.filters;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.rules4j.data.IRule;
import com.rules4j.data.constraints.IConstraint;

public abstract class Filter {

	protected Filter(IRule rule) {
		this.rule = rule;
		this.constraints = new ArrayList<IConstraint>();
	}

	public IRule rule;
	public java.util.List<IConstraint> constraints;

	public void setRule(IRule rule) {
		this.rule = rule;
	}
	
	public List<IConstraint> getConstraints(){
		return this.constraints;
	}

	public Filter Add(IConstraint constraint) {
		this.constraints.add(constraint);
		return this;
	}

	public abstract boolean evaluate(Map<String, Object> data);
}
