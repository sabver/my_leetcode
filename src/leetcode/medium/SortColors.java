package leetcode.medium;

public class SortColors {
	/**
	 * invariant
	 * [0...p0] all 0
	 * [p0+1...p-1] all 1
	 * [p...p2-1] chaos
	 * [p2...length-1] all 2
	 * @param nums
	 */
	public void sortColors(int[] nums) {
		if (nums.length <= 1) {
			return;
		}
		int p = 0, p0 = -1, p2 = nums.length;
		while (p < p2) {
			if( nums[p] == 0 ){
				p0++;
				exchange(nums,p0,p);
				p++;
			}else if( nums[p] == 2 ){
				p2--;
				exchange(nums,p2,p);
			}else{
				p++;
			}
		}
	}

	public void exchange(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public void print(int[] nums) {
		String str = "";
		for (int i = 0; i < nums.length; i++) {
			str += (nums[i] + " ");
		}
		System.out.println(str);
	}

	public static void main(String[] args) {
		SortColors s = new SortColors();
//		int[] nums = {2,0,2,1,1,0};
		int[] nums = {0,0};
		s.sortColors(nums);
		s.print(nums);
	}
}
