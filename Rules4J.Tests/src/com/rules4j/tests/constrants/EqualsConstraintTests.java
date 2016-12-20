package com.rules4j.tests.constrants;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Test;

import com.rules4j.data.IRule;
import com.rules4j.data.Rule;
import com.rules4j.data.constraints.EqualsConstraint;
import com.rules4j.data.filters.Filter;
import com.rules4j.tests.TestBase;

public class EqualsConstraintTests extends TestBase {

	@Test
	public void shouldBePossibleEvaluateRuleWithEqualsConstraint() {
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
	public void shouldNotBePossibleEvaluateRuleWithEqualsConstraintAndNotEqualValue() {
		init();
		IRule rule = new Rule();
		Filter filter = rule.addAndFilter();
		filter.Add(new EqualsConstraint("Name", "John Doe"));
		this.addRule(rule);

		Map<String, Object> data = new HashMap<String, Object>();
		data.put("Name", "Fake User");

		Stream<IRule> rules = this.engine.evaluate(data);

		Assert.assertEquals(0, rules.count());
		clear();
	}

	@Test
	public void shouldNotBePossibleEvaluateRuleWithEqualsConstraintAndNullValue() {
		init();
		IRule rule = new Rule();
		Filter filter = rule.addAndFilter();
		filter.Add(new EqualsConstraint("Name", "John Doe"));
		this.addRule(rule);

		Map<String, Object> data = new HashMap<String, Object>();
		data.put("Name", null);

		Stream<IRule> rules = this.engine.evaluate(data);

		Assert.assertEquals(0, rules.count());
		clear();
	}

}
