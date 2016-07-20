package com.momo.gank.Entity;

import java.util.List;

public class Random {
	
	private boolean error;
	private List<RandomList> results;
	
	public Random() {
		// TODO Auto-generated constructor stub
	}

	public Random(boolean error, List<RandomList> results) {
		super();
		this.error = error;
		this.results = results;
	}

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}

	public List<RandomList> getResults() {
		return results;
	}

	public void setResults(List<RandomList> results) {
		this.results = results;
	}

	@Override
	public String toString() {
		return "Random [error=" + error + ", results=" + results + "]";
	}

}
