package com.rules4j.repository;

import java.util.ArrayList;
import java.util.List;

import com.rules4j.data.IRule;

public class MemoryRuleStore implements IRuleStore {
	private MemoryRuleStore() {
	}

	private List<IRule> rules = new ArrayList<IRule>();

	public static IRuleStore Default = new MemoryRuleStore();

	public void addRule(IRule rule) {
		this.rules.add(rule);
	}

	public List<IRule> get() {
		return this.rules;
	}

	public void clear() {
		this.rules.clear();
	}
}
