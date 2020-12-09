package leetcode.medium;

public class RemoveDuplicatesFromSortedArrayII {
	public int removeDuplicates(int[] nums) {
		if (nums.length <= 2) {
			return nums.length;
		}
		// 下标
		int index = 0;
		int count = 0;
		int lastItem = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == lastItem) {
				count++;
			} else {
				count = 0;
			}
			if (count <= 1) {
				index++;
				nums[index] = nums[i];
			}

			lastItem = nums[i];
		}
		return index + 1;
	}

	public void print(int[] nums) {
		String result = "";
		for (int i = 0; i < nums.length; i++) {
			result += (nums[i] + " ");
		}
		System.out.println(result);
	}

	public static void main(String[] args) {
		RemoveDuplicatesFromSortedArrayII s = new RemoveDuplicatesFromSortedArrayII();
		int[] nums = { 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 4, 4 };
		s.print(nums);
		System.out.println(s.removeDuplicates(nums));
		s.print(nums);
	}
}
