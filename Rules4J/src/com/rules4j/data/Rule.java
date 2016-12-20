package com.rules4j.data;

import java.util.ArrayList;
import java.util.List;

import com.rules4j.data.filters.AndFilter;
import com.rules4j.data.filters.Filter;
import com.rules4j.data.filters.OrFilter;

public class Rule implements IRule {

	private String name;
	public List<Filter> filters;

	public Rule() {
		this.filters = new ArrayList<Filter>();
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public List<Filter> getFilters() {
		return filters;
	}

	@Override
	public Filter addAndFilter() {
        return this.addFilter(new AndFilter(this));
	}

	@Override
	public Filter addOrFilter() {
        return this.addFilter(new OrFilter(this));
	}

	@Override
	public Filter addFilter(Filter filter) {
		 filter.setRule(this);
		 this.filters.add(filter);
         return filter;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

}
