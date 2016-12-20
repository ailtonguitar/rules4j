package com.rules4j.data;

import java.util.List;

import com.rules4j.data.filters.Filter;

public interface IRule {
	void setName(String name);
	String getName();
	List<Filter> getFilters();
	Filter addAndFilter();
	Filter addOrFilter();
	Filter addFilter(Filter filter);
}
