package leetcode.medium;

public class SearchForARange {
	public int[] searchRange(int[] nums, int target) {
		int[] range = { -1, -1 };
//		int result = binarySearch(nums, 0, nums.length - 1, target, range);
//		System.out.println(result);
		binarySearch(nums, 0, nums.length - 1, target, range);
		return range;
	}

	public int binarySearch(int[] nums, int low, int high, int target, int[] range) {
		if (low > high) {
			return -1;
		}
		int mid = (low + high) / 2;
		if (nums[mid] == target) {
			range[0] = range[1] = mid;
			// 往前找
			for (int i = mid - 1; i >= 0; i--) {
				if (nums[mid] != nums[i]) {
					range[0] = i + 1;
					break;
				}
			}
			if (nums[0] == nums[mid]) {
				range[0] = 0;
			}
			// 往后找
			for (int i = mid + 1; i <= nums.length - 1; i++) {
				if (nums[mid] != nums[i]) {
					range[1] = i - 1;
					break;
				}
			}
			if (nums[nums.length - 1] == nums[mid]) {
				range[1] = nums.length - 1;
			}
			return mid;
		} else if (nums[mid] > target) {
			return binarySearch(nums, low, high - 1, target, range);
		} else {
			return binarySearch(nums, low + 1, high, target, range);
		}
	}

	public void printNums(int[] nums) {
		String result = "";
		for (int i = 0; i < nums.length; i++) {
			result += (nums[i] + " ");
		}
		System.out.println(result);
	}

	public static void main(String[] args) {
		SearchForARange s = new SearchForARange();
		int[] nums = { 5, 7, 7, 8, 8, 10 };
		int target = 8;
		s.printNums(s.searchRange(nums, target));
	}
}
