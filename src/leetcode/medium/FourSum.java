package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<List<Integer>> threeSum = null;
		if (nums.length < 4) {
			return result;
		}
		for (int i = 0; i < nums.length - 1; i++) {
			if (i != 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			threeSum = threeSum(nums, target - nums[i], i + 1);
			if (threeSum.size() > 0) {
				for (int j = 0; j < threeSum.size(); j++) {
					result.add(createList(nums[i], threeSum.get(j).get(0), threeSum.get(j).get(1),
							threeSum.get(j).get(2)));
				}
			}
		}
		return result;
	}

	public List<List<Integer>> threeSum(int[] nums, int target, int beginIndex) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		int left, right, sum = 0;
		for (int i = beginIndex; i < nums.length - 1; i++) {
			if (i != beginIndex && nums[i] == nums[i - 1]) {
				continue;
			}
			left = i + 1;
			right = nums.length - 1;
			while (left < right) {
				sum = nums[i] + nums[left] + nums[right];
				if (sum > target) {
					right--;
				} else if (sum < target) {
					left++;
				} else {
					result.add(createList(nums[i], nums[left], nums[right]));
					// 去重
					while (left < right && nums[left + 1] == nums[left]) {
						left++;
					}
					while (left < right && nums[right] == nums[right - 1]) {
						right--;
					}
					left++;
					right--;
				}
			}
		}
		return result;
	}

	public List<Integer> createList(int i, int j, int k) {
		List<Integer> result = new ArrayList<Integer>(3);
		result.add(i);
		result.add(j);
		result.add(k);
		return result;
	}

	public List<Integer> createList(int i, int j, int k, int l) {
		List<Integer> result = new ArrayList<Integer>(4);
		result.add(i);
		result.add(j);
		result.add(k);
		result.add(l);
		return result;
	}

	public void print(List<List<Integer>> result) {
		// 这里打印前100个答案
		System.out.println("size:" + result.size());
		for (int i = 0; i < result.size() && i < 20; i++) {
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

	public static void main(String[] args) {
		FourSum s = new FourSum();
		int nums[] = { 1, 0, -1, 0, -2, 2 };
		int target = 0;
		s.print(s.fourSum(nums, target));
	}
}
