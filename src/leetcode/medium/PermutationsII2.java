package leetcode.medium;

import java.util.*;

public class PermutationsII2 {
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (nums.length == 0) {
			return result;
		}
		if (nums.length == 1) {
			result.add(createList(nums));
			return result;
		}
		if (nums.length == 2) {
			result.add(createList(nums));
			if (nums[0] != nums[1]) {
				exchange(nums, 0, 1);
				result.add(createList(nums));
			}
			return result;
		}
		Set<String> set = new HashSet<String>();
		permute(result, 0, nums, set);
		return result;
	}

	public void permute(List<List<Integer>> result, int fixIndex, int[] nums, Set<String> set) {
		if (fixIndex == nums.length - 3) {
			permuteThree(result, nums, set);
		} else {
			for (int i = fixIndex; i < nums.length; i++) {
				if (nums[i] != nums[fixIndex] || i == fixIndex) {
					exchange(nums, i, fixIndex);
					permute(result, fixIndex + 1, nums, set);
					// 交换回去，避免出现不服预期的顺序
					exchange(nums, i, fixIndex);
				}
			}
		}
	}

	/**
	 * 不断交换后三位的顺序 变换6次之后会恢复原来的顺序
	 * 
	 * @param result
	 * @param nums
	 */
	public void permuteThree(List<List<Integer>> result, int[] nums, Set<String> set) {
		int beginIndex = nums.length - 3;
		int totalCount = 6;
		int count = 0;
		int pointer = beginIndex;
		boolean isValid = true;
		while (count < totalCount) {
			if (isValid) {
				List<Integer> list = createList(nums);
				String listStr = list.toString();
				if (set.contains(listStr) == false) {
					set.add(listStr);
					result.add(list);
				}
			}
			if (pointer == nums.length - 1) {
				// 如果是相等的，那就是下次是无效的
				if (nums[pointer] == nums[beginIndex]) {
					isValid = false;
				} else {
					isValid = true;
					exchange(nums, pointer, beginIndex);
				}
				pointer = beginIndex;
			} else {
				if (nums[pointer] == nums[pointer + 1]) {
					isValid = false;
				} else {
					isValid = true;
					exchange(nums, pointer, pointer + 1);
				}
				pointer++;
			}
			count++;
		}
	}

	public List<Integer> createList(int[] nums) {
		List<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < nums.length; i++) {
			result.add(nums[i]);
		}
		return result;
	}

	/**
	 * 交换i和j的位置
	 * 
	 * @param nums
	 * @param i
	 * @param j
	 */
	public void exchange(int[] nums, int i, int j) {
		// System.out.println("i:" + i + " j:" + j);
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public void print(List<List<Integer>> result) {
		System.out.println("size:" + result.size());
//		for (int i = 0; i < result.size(); i++) {
//			System.out.println(result.get(i));
//		}
	}

	public static void main(String[] args) {
		PermutationsII2 s = new PermutationsII2();
		int[] nums = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 4, 4, 4, 4, 4, 4, 4, 4, 4 };
		s.print(s.permuteUnique(nums));
	}
}
