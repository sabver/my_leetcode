package leetcode.medium;

/**
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]). setting pivot's is 2
 * 
 * @author yejianfeng
 *
 */
public class SearchInRotatedSortedArray {
	/**
	 * 找到最大值的下标
	 * 
	 * @param nums
	 * @param low
	 * @param high
	 * @param pivot
	 * @return
	 */
	public int findMaxIndex(int[] nums, int low, int high, int pivot) {
		int mid = (low + high) / 2;
//		System.out.println("low:" + low + " high:" + high + " mid:" + mid + " pivot:" + pivot);
		if (nums[mid] <= pivot) {
			return findMaxIndex(nums, low, high - 1, pivot);
		} else {
			if (nums[mid] > nums[mid + 1]) {
				return mid;
			} else {
				return findMaxIndex(nums, low + 1, high, pivot);
			}
		}
	}

	public int binarySearch(int[] nums, int low, int high, int target) {
		if (low > high) {
			return -1;
		}
		int mid = (low + high) / 2;
		if (nums[mid] == target) {
			return mid;
		} else if (nums[mid] > target) {
			return binarySearch(nums, low, high - 1, target);
		} else {
			return binarySearch(nums, low + 1, high, target);
		}
	}

	public int search(int[] nums, int target) {
		if (nums.length == 0) {
			return -1;
		}
		int pivot = nums[nums.length - 1];
		if (target == pivot) {
			return nums.length - 1;
		}
		if (nums.length == 1) {
			return -1;
		}
		int result = -1;
		if (nums[nums.length - 1] > nums[0]) {
			result = binarySearch(nums, 0, nums.length - 1, target);
		} else {
			int maxIndex = findMaxIndex(nums, 0, nums.length - 1, pivot);
			System.out.println("maxIndex:" + maxIndex);
			if (target < pivot) {
				result = binarySearch(nums, maxIndex + 1, nums.length - 1, target);
			} else {
				result = binarySearch(nums, 0, maxIndex, target);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		SearchInRotatedSortedArray s = new SearchInRotatedSortedArray();
		int[] nums = { 5,1,3 };
		int target = 1;
		System.out.println(s.search(nums, target));
	}
}
