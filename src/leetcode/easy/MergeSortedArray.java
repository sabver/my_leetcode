package leetcode.easy;

public class MergeSortedArray {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int p1 = m - 1;
		int p2 = n - 1;
		int p = nums1.length - 1;
		while (p2 != -1) {
			if (p1 == -1 || nums2[p2] >= nums1[p1]) {
				nums1[p] = nums2[p2];
				p2--;
			} else {
				exchange(nums1, p1, p);
				p1--;
			}
			p--;
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
		MergeSortedArray s = new MergeSortedArray();
		int[] nums1 = { 0 };
		int[] nums2 = { 2 };
		int m = 0;
		int n = 1;
		s.merge(nums1, m, nums2, n);
		s.print(nums1);
	}
}
