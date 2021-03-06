package com.rules4j.repository;

import java.util.List;

import com.rules4j.data.IRule;

public interface IRuleStore {
	void addRule(IRule rule);
	List<IRule> get();
	void clear();
}
