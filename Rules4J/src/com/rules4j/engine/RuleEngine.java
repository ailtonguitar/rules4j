package com.rules4j.engine;

import java.util.Map;
import java.util.stream.Stream;

import com.rules4j.data.IRule;
import com.rules4j.helpers.ObjectHelper;
import com.rules4j.repository.IRuleStore;

public class RuleEngine implements IRuleEngine {
	private IRuleStore store;

	public RuleEngine(IRuleStore store) {
		this.store = store;
	}

	@Override
	public Stream<IRule> evaluate(Map<String, Object> data) {
        return store.get().stream().filter(r -> r.getFilters().stream().allMatch(f -> f.evaluate(data)));
	}

	@Override
	public Stream<IRule> evaluate(Object data) {
        return this.evaluate(ObjectHelper.toMap(data));
	}
}
