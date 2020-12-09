package leetcode.easy;

/**
 * Given a sorted array and a target value, return the index if the target is
 * found. If not, return the index where it would be if it were inserted in
 * order.
 * 
 * You may assume no duplicates in the array.
 * 
 * @author yejianfeng
 *
 */
public class SearchInsertPosition {
	public int searchInsert2(int[] nums, int target) {
		int result = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == target) {
				return i;
			} else if (nums[i] > target) {
				return i;
			} else {
				result = i;
			}
		}
		if (nums[nums.length - 1] < target) {
			result++;
		}
		return result;
	}

	// 二分法来改善
	public int searchInsert(int[] nums, int target) {
		int binaryResult = binarySearch(nums, target, 0, nums.length - 1);
		if( nums[binaryResult] == target ){
			return binaryResult;
		}else if( nums[binaryResult] > target ){
			return binaryResult;
		}else{
			return binaryResult+1;
		}
	}

	public int binarySearch(int[] nums, int target, int low, int high) {
		if (high <= low) {
			return low;
		}
		int mid = (low + high) / 2;
		System.out.println("low:"+low);
		System.out.println("high:"+high);
		System.out.println("mid:"+mid);
		System.out.println("");
		if (nums[mid] == target) {
			return mid;
		} else if (nums[mid] > target) {
			return binarySearch(nums, target, low, mid - 1);
		} else {
			return binarySearch(nums, target, mid + 1, high);
		}
	}

	public static void main(String[] args) {
		int[] nums = { 1, 3, 5, 6 };
		int target = 2;
		SearchInsertPosition s = new SearchInsertPosition();
		System.out.println(s.searchInsert(nums, target));
	}
}
