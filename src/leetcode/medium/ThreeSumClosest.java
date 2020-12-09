package leetcode.medium;

import java.util.Arrays;
import java.util.HashMap;

public class ThreeSumClosest {

	public int threeSumClosest(int[] nums, int target) {
		return 0;
	}

	// 修正数
	private int fixNum = 0;

	public int threeSumClosest4(int[] nums, int target) {
		if (nums[0] + nums[1] + nums[2] - target == 0) {
			return nums[0] + nums[1] + nums[2];
		}
		int result = nums[0] + nums[1] + nums[2];
		int differenceValue = target - nums[0] - nums[1] - nums[2];
		// hashtable用来保存每个元素出现的次数
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(nums.length / 2);
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				map.put(nums[i], map.get(nums[i]) + 1);
			} else {
				map.put(nums[i], 1);
			}
		}
		int subTarget = 0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				subTarget = target - nums[i] - nums[j];
				if (map.containsKey(subTarget)) {
					if (nums[i] == subTarget && nums[j] == subTarget && map.get(subTarget) >= 3) {
						return target;
					} else if (((nums[i] != subTarget && nums[j] == subTarget)
							|| (nums[i] == subTarget && nums[j] != subTarget)) && map.get(subTarget) >= 2) {
						return target;
					} else if (nums[i] != subTarget && nums[j] != subTarget && map.get(subTarget) >= 1) {
						return target;
					}
				}
				for (int k = j + 1; k < nums.length; k++) {
					if (Math.abs(target - nums[i] - nums[j] - nums[k]) < Math.abs(differenceValue)) {
						result = nums[i] + nums[j] + nums[k];
						differenceValue = target - nums[i] - nums[j] - nums[k];
					}
				}
			}
		}
		return result;
	}

	/**
	 * 考虑一下更好的解法
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public int threeSumClosest3(int[] nums, int target) {
		if (nums[0] + nums[1] + nums[2] - target == 0) {
			return nums[0] + nums[1] + nums[2];
		}
		printNums(nums);
		Arrays.sort(nums);
		printNums(nums);
		if (nums[0] < 0) {
			// fixNum>0 target也被修正为target+3*fixNum
			fixNum = -nums[0];
		}
		if (fixNum != 0) {
			// 去掉数组所有的负数
			for (int i = 0; i < nums.length; i++) {
				nums[i] += fixNum;
			}
		}
		System.out.println("fixNum:" + this.fixNum);
		printNums(nums);
		int result = nums[0] + nums[1] + nums[2];
		int differenceValue = target + 3 * this.fixNum - nums[0] - nums[1] - nums[2];
		System.out.println("differenceValue:" + differenceValue);
		// hashtable用来保存每个元素出现的次数
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(nums.length / 2);
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				map.put(nums[i], map.get(nums[i]) + 1);
			} else {
				map.put(nums[i], 1);
			}
		}
		int subTarget = 0;
		int k = 0;
		System.out.println();
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				System.out.println("i:" + i + " value:" + nums[i] + " j:" + j + " value:" + nums[j]);
				subTarget = target + 3 * this.fixNum - nums[i] - nums[j];
				System.out.println("subTarget:" + subTarget);
				// 如果小于0了，就没有必要再找了，因为现在的nums都是>=0的
				// if (subTarget < 0) {
				// break;
				// }
				if (subTarget >= 0 && map.containsKey(subTarget)) {
					if (nums[i] == subTarget && nums[j] == subTarget && map.get(subTarget) >= 3) {
						return target;
					} else if ((nums[i] == subTarget || nums[j] == subTarget) && map.get(subTarget) >= 2) {
						return target;
					} else if (nums[i] != subTarget && nums[j] != subTarget && map.get(subTarget) >= 1) {
						return target;
					}
				}
				// 之后的数也没有必要比较了，因为后面的数会越来越大，而现在nums[k]已经大于subTarget了
				// k = findMaxFarIndex(nums, subTarget, j, nums.length - 1);
				k = nums.length - 1;
				System.out.println("k:" + k);
				// // 这里作最后一次比较
				// if (k != j && Math.abs(target + 3 * this.fixNum - nums[i] -
				// nums[j] - nums[k]) < Math
				// .abs(differenceValue)) {
				// System.out.println("bingo i:" + i + " j:" + j + " k:" + k);
				// result = nums[i] + nums[j] + nums[k];
				// differenceValue = target + 3 * this.fixNum - nums[i] -
				// nums[j] - nums[k];
				// }
				// System.out.println("result:" + result);
				// 这里要往前面回溯
				for (int inner = k; inner >= j + 1; inner--) {
					// nums[inner]会不断减少
					if (Math.abs(target + 3 * this.fixNum - nums[i] - nums[j] - nums[inner]) < Math
							.abs(differenceValue)) {
						System.out.println("bingo i:" + i + " j:" + j + " inner:" + inner);
						result = nums[i] + nums[j] + nums[inner];
						differenceValue = target + 3 * this.fixNum - nums[i] - nums[j] - nums[inner];
					}
					System.out.println("i:" + i + " j:" + j + " inner:" + inner);
				}
				System.out.println("differenceValue:" + differenceValue);
				System.out.println("result:" + result);
				System.out.println();
			}
		}
		return result - 3 * this.fixNum;
	}

	/**
	 * 找到最远的可能下标 结果下标result的情况：nums[result]>=target
	 * 
	 * @param sum
	 * @param nums
	 * @return
	 */
	public int findMaxFarIndex(int nums[], int target, int low, int high) {
		if (low > high) {
			if (low >= nums.length) {
				return low - 1;
			}
			return low;
		}
		int mid = (low + high) / 2;
		if (mid >= nums.length) {
			return mid - 1;
		}
		if (nums[mid] == target) {
			int index = mid;
			// 这里会遇到后面连续都是相同值的情况，这时要拿到最后的位置
			for (int i = low; i < nums.length - 1; i++) {
				if (nums[i] == nums[i + 1] && nums[i] == target) {
					index = i + 1;
				}
			}
			if (index >= nums.length) {
				return nums.length - 1;
			}
			return index;
		} else if (nums[mid] > target) {
			return findMaxFarIndex(nums, target, low, mid - 1);
		} else {
			return findMaxFarIndex(nums, target, mid + 1, high);
		}
	}

	/**
	 * 先用暴力法解决 You may assume that each input would have exactly one solution.
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public int threeSumClosest2(int[] nums, int target) {
		if (nums.length < 3) {
			return 0;
		}
		int result = nums[0] + nums[1] + nums[2];
		int differenceValue = nums[0] + nums[1] + nums[2] - target;
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				for (int k = j + 1; k < nums.length; k++) {
					if (Math.abs(nums[i] + nums[j] + nums[k] - target) < Math.abs(differenceValue)) {
						differenceValue = nums[i] + nums[j] + nums[k] - target;
						result = nums[i] + nums[j] + nums[k];
					}
				}
			}
		}
		return result;
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

	public void test() {
		int[] nums = { 1, 3, 5, 6, 7, 9, 11, 13 };
		int[] testValue = { 0, 2, 4, 6, 8, 10, 14 };
		int target = 0;
		for (int i = 0; i < testValue.length; i++) {
			// 预期 nums[result]>=target
			int result = findMaxFarIndex(nums, testValue[i], 0, nums.length - 1);
			if (nums[result] < testValue[i] && result != nums.length - 1) {
				System.out.println("error");
			}
			System.out.println("target:" + testValue[i] + " index:" + result + " value:" + nums[result]);
		}
	}

	public static void main(String[] args) {
		ThreeSumClosest s = new ThreeSumClosest();
		int[] nums = { -1, 0, 1, 1, 55 };
		int target = 3;
		System.out.println(s.threeSumClosest(nums, target));
		// s.test();
	}
}
