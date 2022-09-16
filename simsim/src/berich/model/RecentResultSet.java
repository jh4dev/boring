package berich.model;

import java.util.Arrays;

public class RecentResultSet {

	private int week;
	private int[] results;
	
	public int getWeek() {
		return week;
	}
	public void setWeek(int week) {
		this.week = week;
	}
	public int[] getResults() {
		return results;
	}
	public void setResults(int[] results) {
		this.results = results;
	}
	@Override
	public String toString() {
		return "RecentResultSet [week=" + week + ", results=" + Arrays.toString(results) + "]";
	}
	
	
}
