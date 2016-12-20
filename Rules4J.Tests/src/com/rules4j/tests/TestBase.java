package com.rules4j.tests;

import com.rules4j.data.IRule;
import com.rules4j.engine.IRuleEngine;
import com.rules4j.engine.RuleEngine;
import com.rules4j.repository.IRuleStore;
import com.rules4j.repository.MemoryRuleStore;

public class TestBase {

	private IRuleStore store;
	protected IRuleEngine engine;

	protected void init() {
		this.store = MemoryRuleStore.Default;
		this.engine = new RuleEngine(this.store);
	}

	public void End() {
		this.clear();
	}

	protected void addRule(IRule rule) {
		this.store.addRule(rule);
	}

	protected void clear() {
		this.store.clear();
	}
}
