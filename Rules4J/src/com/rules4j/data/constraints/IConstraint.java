package com.rules4j.data.constraints;

import java.util.Map;

public interface IConstraint {
	boolean evaluate(Map<String, Object> data);
}
