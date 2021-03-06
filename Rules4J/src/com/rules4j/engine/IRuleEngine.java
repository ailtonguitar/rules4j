package com.rules4j.engine;

import java.util.Map;
import java.util.stream.Stream;

import com.rules4j.data.IRule;

public interface IRuleEngine {
    Stream<IRule> evaluate(Map<String, Object> data);
    Stream<IRule> evaluate(Object data);
    //Stream<IRule> evaluateAndFire(Map<String, Object> data);
    //Stream<IRule> evaluateAndFire(Object data);
}
