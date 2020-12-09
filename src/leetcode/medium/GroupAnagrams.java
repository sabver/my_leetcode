package leetcode.medium;

import java.util.*;

public class GroupAnagrams {
	private HashMap<Character, Integer> map;

	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> result = new ArrayList<List<String>>();
		if (strs.length == 0) {
			return result;
		}
		init();
		HashMap<Integer, List<String>> resultMap = new HashMap<Integer, List<String>>();
		int curCal = 1;
		List<String> indexList = null;
		for(int i=0;i<strs.length;i++){
			curCal = cal(strs[i].toCharArray());
			if( resultMap.containsKey(curCal) ){
				indexList = resultMap.get(curCal);
				indexList.add(strs[i]);
			}else{
				indexList = new ArrayList<String>();
				indexList.add(strs[i]);
				resultMap.put(curCal, indexList);
			}
		}
		//整理答案
		Iterator<Integer> it = resultMap.keySet().iterator();
		while( it.hasNext() ){
			result.add(resultMap.get(it.next()));
		}
		return result;
	}

	public Integer cal(char[] chars) {
		int result = 1;
		for (int i = 0; i < chars.length; i++) {
			result *= map.get(chars[i]);
		}
		return result;
	}

	public void init() {
		map = new HashMap<Character, Integer>(26);
		int[] primes = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97,
				101 };
		char[] alphabets = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
				's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
		for (int i = 0; i < primes.length; i++) {
			map.put(alphabets[i], primes[i]);
		}
	}

	public void print(List<List<String>> result) {
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}
	}

	public static void main(String[] args) {
		GroupAnagrams s = new GroupAnagrams();
		String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
		s.print(s.groupAnagrams(strs));
		s.init();
	}
}
