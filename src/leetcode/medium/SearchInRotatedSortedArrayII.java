package leetcode.medium;

public class SearchInRotatedSortedArrayII {
	public boolean search(int[] nums, int target) {
		if (nums.length == 0) {
			return false;
		}
		if (nums.length == 1) {
			return nums[0] == target;
		}
		if (nums[0] < nums[nums.length - 1]) {
			return binarySearch(nums, 0, nums.length - 1, target) != -1;
		} else {
			int pivot = nums[nums.length - 1];
			// 这里要先排除左边所有和pivot相同的元素
			if (pivot == target) {
				return true;
			}
			int beginIndex = 0;
			if (nums[0] == pivot) {
				beginIndex = findLastSameOneIndex(nums, 0, nums.length - 2, pivot) + 1;
			}
			int maxIndex = findMaxIndex(nums, beginIndex, nums.length - 1, pivot);
			if (target <= pivot) {
				return binarySearch(nums, maxIndex + 1, nums.length - 1, target) != -1;
			} else {
				return binarySearch(nums, beginIndex, maxIndex, target) != -1;
			}
		}
	}

	/**
	 * 这里假定左边一定有一个pivot的
	 * 
	 * @param nums
	 * @param low
	 * @param high
	 * @param pivot
	 * @return
	 */
	public int findLastSameOneIndex(int[] nums, int low, int high, int pivot) {
		if (low > high) {
			return 1;
		}
		int mid = (low + high) / 2;
		if (nums[mid] == pivot && nums[mid + 1] != pivot) {
			return mid;
		} else if (nums[mid] == pivot && nums[mid + 1] == pivot) {
			return findLastSameOneIndex(nums, low + 1, high, pivot);
		} else {
			return findLastSameOneIndex(nums, low, high - 1, pivot);
		}
	}

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
		if (low > high) {
			return high;
		}
		int mid = (low + high) / 2;
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

	public static void main(String[] args) {
		SearchInRotatedSortedArrayII s = new SearchInRotatedSortedArrayII();
		int[] nums = { 1, 1, 1, 2, 1 };
		int target = 3;
		// System.out.println(s.findLastSameOneIndex(nums, 0, nums.length - 2,
		// nums[nums.length - 1]));
		System.out.println(s.search(nums, target));
	}
}
