package leetcode.medium;

import java.util.*;

public class Permutations3 {

	public List<List<Integer>> permute(int[] nums) {
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
			exchange(nums, 0, 1);
			result.add(createList(nums));
			return result;
		}
		permute(result, 0, nums);
		return result;
	}

	public void permute(List<List<Integer>> result, int fixIndex, int[] nums) {
		if (fixIndex == nums.length - 3) {
			permuteThree(result, nums);
		} else {
			for (int i = fixIndex; i < nums.length; i++) {
				exchange(nums, i, fixIndex);
				permute(result, fixIndex + 1, nums);
				// 交换回去，避免出现不服预期的顺序
				exchange(nums, i, fixIndex);
			}
		}
	}

	/**
	 * 不断交换后三位的顺序 变换6次之后会恢复原来的顺序
	 * 
	 * @param result
	 * @param nums
	 */
	public void permuteThree(List<List<Integer>> result, int[] nums) {
		int beginIndex = nums.length - 3;
		int totalCount = 6;
		int count = 0;
		int pointer = beginIndex;
		while (count < totalCount) {
			result.add(createList(nums));
			if (pointer == nums.length - 1) {
				exchange(nums, pointer, beginIndex);
				pointer = beginIndex;
			} else {
				exchange(nums, pointer, pointer + 1);
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
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}
	}

	public void printNums(int[] nums) {
		String str = "";
		for (int i = 0; i < nums.length; i++) {
			str += (nums[i] + " ");
		}
		System.out.println(str);
	}

	/**
	 * 求n的阶乘F
	 * 
	 * @param n
	 * @return
	 */
	public int factorial(int n) {
		if (n == 0) {
			return 1;
		}
		return n * factorial(n - 1);
	}

	public void test(List<List<Integer>> result) {
		System.out.println("相同的元素有：");
		int count = 0;
		Set<String> set = new HashSet<String>();
		for (int i = 0; i < result.size(); i++) {
			if (set.contains(result.get(i).toString())) {
				count++;
				System.out.println(result.get(i).toString() + " - same");
			} else {
				set.add(result.get(i).toString());
				System.out.println(result.get(i).toString());
			}
		}
		System.out.println("count:" + count);
		System.out.println("size:" + result.size());
	}

	public static void main(String[] args) {
		Permutations3 s = new Permutations3();
		int[] nums = { 1,2,3,4 };
		s.print(s.permute(nums));
		// s.test(s.permute(nums));
		System.out.println(s.factorial(nums.length));
		// s.permuteThree(new ArrayList<List<Integer>>(), nums);
	}
}
