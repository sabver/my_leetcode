package leetcode.medium;

import java.util.Arrays;

/**
 * 如果当前排列是124653,找它的下一个排列的方法是，从这个序列中从右至左找第一个左邻小于右邻的数，12(46)53
 * 
 * 如果找不到，则所有排列求解完成，如果找得到则说明排列未完成。
 * 
 * 本例中将找到46,计4所在的位置为i,找到后不能直接将46位置互换，而又要从右到左到第一个比4大的数，1246(5)3
 * 
 * 本例找到的数是5，其位置计为j，将i与j所在元素交换125643,12(5)6(4)3
 * 
 * 然后将i+1至最后一个元素从小到大排序得到125346，这就是124653的下一个排列。125(346)
 * 
 * @author yejianfeng
 *
 */
public class NextPermutation {
	public void nextPermutation(int[] nums) {
		int i = -1, j = nums.length - 1;
		// 这个序列中从右至左找第一个左邻小于右邻的数，左邻的下标计为i
		for (int index = nums.length - 1; index >= 1; index--) {
			if (nums[index - 1] < nums[index]) {
				i = index - 1;
				break;
			}
		}
		// 如果找不到，则所有排列求解完成，如果找得到则说明排列未完成。
		if (i == -1) {
			// 找不到则是都是倒序，需要排序
			Arrays.sort(nums);
			return;
		}
		// 又要从右到左到第一个比nums[i]大的数，下标计为j
		for (int index = nums.length - 1; index >= 0; index--) {
			if (nums[index] > nums[i]) {
				j = index;
				break;
			}
		}
		// 将i与j所在元素交换
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
		// 然后将i+1至最后一个元素从小到大排序
		Arrays.sort(nums, i + 1, nums.length);
	}

	public void printNums(int[] nums) {
		String result = "";
		for (int i = 0; i < nums.length; i++) {
			result += (nums[i] + " ");
		}
		System.out.println(result);
	}

	public static void main(String[] args) {
		NextPermutation s = new NextPermutation();
		int[] nums = { 1, 2, 3, 4 };
		for (int i = 0; i < 24; i++) {
			s.nextPermutation(nums);
			s.printNums(nums);
		}
	}
}
