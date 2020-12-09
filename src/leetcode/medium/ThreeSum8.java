package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum8 {
	/**
	 * idea是借鉴的
	 * @param nums
	 * @return
	 */
	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		int left, right, sum = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			if (i != 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			left = i + 1;
			right = nums.length - 1;
			while (left < right) {
				sum = nums[i] + nums[left] + nums[right];
				if (sum > 0) {
					right--;
				} else if (sum < 0) {
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

	/**
	 * 将三个数组合成一个List
	 * 
	 * @param i
	 * @param j
	 * @param k
	 * @return
	 */
	public List<Integer> createList(int i, int j, int k) {
		List<Integer> result = new ArrayList<Integer>(3);
		result.add(i);
		result.add(j);
		result.add(k);
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

	public void printNums(int[] nums) {
		System.out.println("nums.length:" + nums.length);
		String str = "[";
		for (int i = 0; i < nums.length; i++) {
			if (i == nums.length - 1) {
				str += nums[i];
			} else {
				str += (nums[i] + ",");
			}
		}
		System.out.println(str + "]");
	}

	public static void main(String[] args) {
		ThreeSum8 s = new ThreeSum8();
		long time = System.currentTimeMillis();
		int nums[] = { -1, -2, -3, 4, 1, 3, 0, 3, -2, 1, -2, 2, -1, 1, -5, 4, -3 };
		// int nums[] = { -1, 0, 1, 0 };
		// int nums[] = { -1, 0, 0, 0, 0 };
		// int nums[] = { -1, -2, -3, 4, 1, 3, 0, 3, -2, 1, -2, 2, -1, 1, -5, 4,
		// -3 };
		// int nums[] = ThreeSumTestData.data;
		// System.out.println("nums length:" + nums.length);
		// s.threeSum(nums);
		s.print(s.threeSum(nums));
		// 1304
		System.out.println("runtime:" + (System.currentTimeMillis() - time));
		// for (int i = 0; i < nums.length; i++) {
		// System.out.println(nums[i]);
		// }
		// System.out.println(s.findMaxFarIndex(1, nums2, 0, nums.length - 1));
	}
}
