package com.rules4j.tests;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Test;

import com.rules4j.data.IRule;
import com.rules4j.data.Rule;
import com.rules4j.data.constraints.EqualsConstraint;
import com.rules4j.data.filters.Filter;

public class RuleEngineTests extends TestBase {

	@Test
	public void shouldBePossibleEvaluateRule() {
		init();
		IRule rule = new Rule();
		Filter filter = rule.addAndFilter();
		filter.Add(new EqualsConstraint("Name", "John Doe"));
		this.addRule(rule);

		Map<String, Object> data = new HashMap<String, Object>();
		data.put("Name", "John Doe");

		Stream<IRule> rules = this.engine.evaluate(data);

		Assert.assertEquals(1, rules.count());
		clear();
	}

	@Test
	public void shouldBePossibleEvaluateRuleWithBean() {
		init();
		IRule rule = new Rule();
		Filter filter = rule.addAndFilter();
		filter.Add(new EqualsConstraint("name", "John Doe"));
		this.addRule(rule);

		RuleFakeBean data = new RuleFakeBean();
		data.setName("John doe");
		Stream<IRule> rules = this.engine.evaluate(data);
		long count = rules.count();
		Assert.assertEquals(1, count);
		clear();
	}
}

class RuleFakeBean {
	private String name;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
}
