package leetcode.medium;

import java.util.HashMap;

import leetcode.util.Util;

public class PartitionToKEqualSumSubsets {

	public boolean canPartitionKSubsets(int[] nums, int k) {
		// 排除一些基本情况
		if (k > nums.length)
			return false;
		int sum = 0;
		for (int v : nums)
			sum += v;
		if (sum % k != 0)
			return false;

		int used = 0; // 使用位图技巧
		int target = sum / k;
		// k 号桶初始什么都没装，从 nums[0] 开始做选择
		return backtrack(k, 0, nums, 0, used, target);
	}

	HashMap<Integer, Boolean> memo = new HashMap<>();

	boolean backtrack(int k, int bucket, int[] nums, int start, int used, int target) {
		// base case
		if (k == 0) {
			// 所有桶都被装满了，而且 nums 一定全部用完了
			return true;
		}
		if (bucket == target) {
			// 装满了当前桶，递归穷举下一个桶的选择
			// 让下一个桶从 nums[0] 开始选数字
			boolean res = backtrack(k - 1, 0, nums, 0, used, target);
			// 缓存结果
			memo.put(used, res);
			return res;
		}

		if (memo.containsKey(used)) {
			// 避免冗余计算
			return memo.get(used);
		}

		for (int i = start; i < nums.length; i++) {
			// 剪枝
			if (((used >> i) & 1) == 1) { // 判断第 i 位是否是 1
				// nums[i] 已经被装入别的桶中
				continue;
			}
			if (nums[i] + bucket > target) {
				continue;
			}
			// 做选择
			used |= 1 << i; // 将第 i 位置为 1
			bucket += nums[i];

			// 递归穷举下一个数字是否装入当前桶
			if (backtrack(k, bucket, nums, i + 1, used, target)) {
				return true;
			}
			// 撤销选择 ^是XOR
			used ^= 1 << i; // 将第 i 位置为 0
			bucket -= nums[i];
		}

		return false;
	}

	public static void main(String[] args) {
//		PartitionToKEqualSumSubsets p = new PartitionToKEqualSumSubsets();
//		int[] nums = { 3, 3, 10, 2, 6, 5, 10, 6, 8, 3, 2, 1, 6, 10, 7, 2 };
//		int k = 6;
//		Util.p(p.canPartitionKSubsets(nums, k));

//		int used = 0, i = 4;
//		int used2 = used |= 1 << i;
//		Util.p(used2);
//		int used3 = used >> i;
//		Util.p(used3);
//		int used4 = 0 & 1;
//		Util.p(used4);
		int used5 = 14;
		Util.p(used5 ^ (1 << 2));
		Util.p((1 << 2));
	}

}
