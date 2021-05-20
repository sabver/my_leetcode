package leetcode.hard;

import java.util.Arrays;
import java.util.Comparator;

public class RussianDollEnvelopes354 {
	public int maxEnvelopes(int[][] envelopes) {
		Comparator<int[]> comparator = new Comparator<int[]>() {
			public int compare(int[] array1, int[] array2) {
				// 对宽进行升序排序
				if (array1[0] > array2[0]) {
					return 1;
				} else if (array1[0] < array2[0]) {
					return -1;
				} else {
					// 宽度相同的对长进行降序排序
					if (array1[1] < array2[1]) {
						return 1;
					} else {
						return -1;
					}
				}
			}
		};
		Arrays.sort(envelopes, comparator);
//		for (int i = 0; i < envelopes.length; i++) {
//			for (int j = 0; j < envelopes[0].length; j++) {
//				System.out.print(envelopes[i][j] + " ");
//			}
//			System.out.println();
//		}
		int[] heights = new int[envelopes.length];
		for (int i = 0; i < envelopes.length; i++) {
			heights[i] = envelopes[i][1];
		}
		return lengthOfLIS(heights);
	}

	/**
	 * 最长递增子序列
	 * 
	 * @param nums
	 * @return
	 */
	public int lengthOfLIS(int[] nums) {
		int[] tops = new int[nums.length];
		// 堆的个数
		int piles = 0;
		for (int i = 0; i < nums.length; i++) {
			// 需要处理的扑克牌
			int poker = nums[i];
			int left = 0, right = piles-1;
			// 二分法 找到堆里面左侧边界，也就是找到有多少个堆顶是小于nums[i]
			while (left <= right) {
				int mid = left + (right - left) / 2;
				if (tops[mid] == poker) {
					right = mid - 1;
				} else if (tops[mid] > poker) {
                    right = mid - 1;					
				} else {
					left = mid + 1;
				}
			}
			// 所有的堆都小于nums[i]，只能新建一个堆了
			if (left == piles) {
				piles++;
			}
			tops[left] = poker;
		}
		return piles;
	}

	public static void main(String[] args) {
		RussianDollEnvelopes354 d = new RussianDollEnvelopes354();
		int[][] envelopes = { { 5, 4 }, { 6, 4 }, { 6, 7 }, { 2, 3 }, };
		d.maxEnvelopes(envelopes);
	}
}
