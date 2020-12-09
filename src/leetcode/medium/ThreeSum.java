package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ThreeSum {
	public List<List<Integer>> threeSum(int[] nums) {
		// 先排序 默认从小到大
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		List<Integer> list = null;
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i]) == false) {
				list = new ArrayList<Integer>();
				list.add(i);
				map.put(nums[i], list);
			} else {
				map.get(nums[i]).add(i);
			}
		}
//		printMap(map, nums);
		int sum = 0;
		int index = 0;
		for (int i = 0; i < nums.length; i++) {
			updateMap(nums, i, map);
			for (int j = i + 1; j < nums.length; j++) {
				updateMap(nums, j, map);
				sum = nums[i] + nums[j];
				if (map.containsKey(-sum)) {
					// System.out.println("-sum:" + -sum + " list:" +
					// map.get(-sum));
					// 默认都是用第一个的
					index = map.get(-sum).get(0);
					// System.out.println("index:" + index);
					if (index > j) {
						// System.out.println("i:" + i + " j:" + j + " index:" +
						// index);
//						if (isHaveSame(result, nums[i], nums[j], nums[index]) == false) {
//							result.add(createList(nums[i], nums[j], nums[index]));
//						}
						result.add(createList(nums[i], nums[j], nums[index]));
					}
				}
				// System.out.println();
			}
		}
		deleteDuplicateTriplets(result);
		return result;
	}
	
	public void deleteDuplicateTriplets(List<List<Integer>> list) {
		int size = list.size();
		if( size<=1 ){
			return;
		}
		for (int i = size - 1; i >= 0; i--) {
			if( isHaveSame(list,list.get(i),i) ){
				list.remove(i);
			}
		}
	}

	public boolean isHaveSame(List<List<Integer>> list, List<Integer> item, int curIndex) {
		int size = list.size();
		if (size == 0) {
			return false;
		}
		for (int i = size - 1; i >= 0; i--) {
			if (list.get(i).get(0) == item.get(0) && list.get(i).get(1) == item.get(1) && i != curIndex) {
				return true;
			}
		}
		return false;
	}	

	public boolean isHaveSame(List<List<Integer>> list, int one, int two, int three) {
		int size = list.size();
		if (size == 0) {
			return false;
		}
		for (int i = size - 1; i >= 0; i--) {
			if (list.get(i).get(0) == one && list.get(i).get(1) == two) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 将三个数组合成一个List
	 * 
	 * @param i
	 * @param j
	 * @param k
	 * @return
	 */
	public List<Integer> createList(int i, int j, int k) {
		List<Integer> result = new ArrayList<Integer>();
		result.add(i);
		result.add(j);
		result.add(k);
		return result;
	}

	public void updateMap(int[] nums, int i, HashMap<Integer, List<Integer>> map) {
		List<Integer> list = map.get(nums[i]);
		if (list.size() > 1) {
			list.remove(0);
		}
	}

	public void print(List<List<Integer>> result) {
		System.out.println("size:" + result.size());
		for (int i = 0; i < result.size(); i++) {
			String str = "[";
			for (int j = 0; j < result.get(i).size(); j++) {
				if (j == result.get(i).size() - 1) {
					str += result.get(i).get(j);
				} else {
					str += (result.get(i).get(j) + ",");
				}
			}
			System.out.println(str + "]");
		}
	}

	public void printMap(HashMap<Integer, List<Integer>> map, int nums[]) {
		List<Integer> list = null;
		for (int i = 0; i < nums.length; i++) {
			list = map.get(nums[i]);
			String str = "i:" + i + " nums[i]:" + nums[i] + "  indexs:";
			for (int j = 0; j < list.size(); j++) {
				str += (list.get(j) + " ");
			}
			System.out.println(str);
		}
	}

	public static void main(String[] args) {
		ThreeSum s = new ThreeSum();
		int nums[] = { -1, -2, -3, 4, 1, 3, 0, 3, -2, 1, -2, 2, -1, 1, -5, 4, -3 };
		// s.threeSum(nums);
		s.print(s.threeSum(nums));
	}
}
