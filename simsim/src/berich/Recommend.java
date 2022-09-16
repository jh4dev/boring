package berich;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import berich.model.NumberSet;
import berich.model.RecentResultSet;

public class Recommend {

	private static final int _TOTAL_SIZE 	= 45;
	private static final int _RESULT_SIZE	= 6;
	
	private static final int _BASE_WEIGHT	= 100;
	
	private static final int _RECENT_WEEK_DURATION = 2;
	
	public static void main(String[] args) {

		for(int i = 0; i < 100; i++) {
			drawLottery();
		}
		
	}
	
	private static void drawLottery() {
		
		List<Integer> resultList = new ArrayList<Integer>();
		
		List<NumberSet> baseList = getBaseList();
		
		List<RecentResultSet> recentList = getRecentResultSample(_RECENT_WEEK_DURATION);
	
		int weekWeight = 10;
		for(int i = 0; i < _RECENT_WEEK_DURATION; i++) {
			
			int[] recent = recentList.get(i).getResults();
			for(int n : recent) {
				baseList.get(n - 1).subWeight(weekWeight);
			}
			
			weekWeight += 5;
		}
		
		int resultIdx = 1;
		while(resultIdx <= _RESULT_SIZE) {
			
			NumberSet nSet =  baseList.get(getRandomNumber(_TOTAL_SIZE - 1));
			
			if(nSet.getWeight() >= getRandomNumber(_BASE_WEIGHT)) {
				nSet.setWeight(0);
				resultList.add(nSet.getNumber());
				resultIdx++;
			}
			
		}
		
//		System.out.println(resultList);
		System.out.println(sortNumber(resultList));
		
	}
	
	/**
	 * init
	 * numbers 1 to 45
	 * weight 100
	 * */
	private static List<NumberSet> getBaseList() {
	
		List<NumberSet> list = new ArrayList<NumberSet>();
		
		for(int i = 1; i <= _TOTAL_SIZE; i++) {
			
			list.add(new NumberSet(i, _BASE_WEIGHT));
		}
		
		return list;
	}
	
	
	private static List<RecentResultSet> getRecentResultSample(int weekCnt) {

		RecentResultSet result1 = new RecentResultSet();
		result1.setWeek(35);
		result1.setResults(new int[]{6,	7, 22, 32, 35, 36, 19});
		
		RecentResultSet result2 = new RecentResultSet();
		result2.setWeek(36);
		result2.setResults(new int[]{1, 6, 12, 19, 36, 42, 28});
		
		List<RecentResultSet> list = new ArrayList<>();
		
		list.add(result1);
		list.add(result2);
		
		return list;
	}
	
	private static int getRandomNumber(int size) {
		
		Random rand = new Random();
		return rand.nextInt(size);
	}
	
	private static List<Integer> sortNumber(List<Integer> list ) {

		int minNum = 0;
		int minIdx = 0;
		int tmpNumber = 0;

		for(int i = 0; i < list.size() -1; i++) {
			
			minIdx = i;
			minNum = list.get(i);
			tmpNumber = list.get(i);
			
			for(int j = i+1; j < list.size(); j++) {
				
				if(list.get(j) < minNum) {
					minNum = list.get(j);
					minIdx = j;
				}
			}
			list.set(i, minNum);
			list.set(minIdx, tmpNumber);
			
		}
		
		return list;
	}
}
