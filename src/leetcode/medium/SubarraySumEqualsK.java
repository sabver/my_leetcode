package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

import leetcode.util.Util;

public class SubarraySumEqualsK {
	public int subarraySum(int[] nums, int k) {
		int presums[] = new int[nums.length + 1];
		presums[0] = 0;
//		for (int i = 1; i < presums.length; i++) {
//			presums[i] += presums[i - 1] + nums[i - 1];
//		}
		Util.printArray(presums);
		// presums[j] - presums[i] = k => presums[j] = presums[i] + k
		// presums[i] => index set
		Map<Integer, Integer> count = new HashMap<>();
		count.put(0, 1);
		int res = 0;
		for (int i = 1; i < presums.length; i++) {
			presums[i] += presums[i - 1] + nums[i - 1];
			// 现在的i在未来，count map存的是过去的记录
			int need = presums[i] - k;
			if( count.containsKey(need) ) {
				res += count.get(need);
			}
			// 一开始count没数据，所以需要保存
			if( count.containsKey(presums[i]) ) {
				count.put(presums[i], count.get(presums[i]) + 1);
			} else {
				count.put(presums[i], 1);
			}
		}
		return res;
	}

	public static void main(String args[]) {
		SubarraySumEqualsK ssek = new SubarraySumEqualsK();
		int[] nums = new int[] { 1, 1, 1 };
//		int[] nums = new int[] { 1 };
		int k = 2;
//		int k = 0;
		int res = ssek.subarraySum(nums, k);
		System.out.println("res:" + res);
	}

}
