package leetcode.easy;

public class RemoveDuplicatesFromSortedArray {
	public int removeDuplicates(int[] nums) {
		if (nums.length == 1 || nums.length == 0) {
			return nums.length;
		}
		// 统计个数
		int index = 1;
		int polar = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (polar!=nums[i]) {
				nums[index] = nums[i];
				index++;
			}
			polar = nums[i];
//			System.out.println("index:"+index);
		}
		return index;
	}
	/**
	 * 去除数组里面的重复元素然后返回处理后的数组长度
	 * 
	 * @param nums
	 * @return
	 */
	public int removeDuplicates2(int[] nums) {
		if (nums.length == 1 || nums.length == 0) {
			return nums.length;
		}
		// 这个数组设置每个第一次出现元素的对应下标为1，其他相同元素的下标标记为-1
		int sameItemIndexs[] = new int[nums.length];
		// set damp
		for (int i = 0; i < sameItemIndexs.length; i++) {
			sameItemIndexs[i] = -1;
		}
		sameItemIndexs[0] = 1;
		int polar = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if( nums[i] != polar ){
				sameItemIndexs[i] = 1;
			}
			polar = nums[i];
		}
//		print(sameItemIndexs);
		// 统计个数
		int index = 0;
		for (int i = 0; i < sameItemIndexs.length; i++) {
			if (sameItemIndexs[i] != -1) {
				nums[index] = nums[i];
				index++;
			}
		}
//		System.out.println(index);
		return index;
	}

	public void print(int[] nums) {
		String result = "";
		for (int i = 0; i < nums.length; i++) {
			result += (nums[i] + " ");
		}
		System.out.println(result);
	}

	public static void main(String[] args) {
		RemoveDuplicatesFromSortedArray s = new RemoveDuplicatesFromSortedArray();
		int nums[] = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
		s.print(nums);
		System.out.println(s.removeDuplicates(nums));
		s.print(nums);
	}
}
