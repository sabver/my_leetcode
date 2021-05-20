package leetcode.test;

public class Binary {
	/**
	 * 基本的二分检索，这里假定nums是递增的
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public int binarySearch(int[] nums, int target) {
		int left = 0, right = nums.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] > target) { // target在左区间
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return -1;
	}

	/**
	 * 二分检索，返回左侧边界 这里会有一个疑问是，因为这里命中之后是把right设定为mid-1的，那么在命中了之后，这个程序还是会继续执行的。
	 * 之后，因为left和right都是往target的左边偏了，所以最后查找的时候会触发nums[mid] < target，所以left = mid +
	 * 1， 从结果上来看会执行修正
	 * @param nums
	 * @param target
	 * @return
	 */
	public int leftBound(int[] nums, int target) {
		int left = 0, right = nums.length - 1;
		// 检索区间为[left,right]
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] == target) {
				// 注意，这里不是直接返回mid，而是收缩右侧边界
				right = mid - 1;
			} else if (nums[mid] > target) { // target在左区间
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		// 这里放回的结果可以换中解释就是，返回有多少条数据是小于target的，这里需要解除left >= nums.length || nums[left] != target这个条件
		// 检查出界情况
//		if (left >= nums.length || nums[left] != target) {
//			return -1;
//		}
		//
		return left;
	}

	/**
	 * 二分检索，返回右边边界
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public int rightBound(int[] nums, int target) {
		int left = 0, right = nums.length-1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] == target) {
				// 注意，这里不是直接返回mid，而是收缩左侧边界
				left = mid + 1;
			} else if (nums[mid] > target) { // target在左区间
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		if( right <= -1|| nums[right] != target ) {
			return -1;
		}
		return right;
	}

	public static void main(String[] args) {
		Binary b = new Binary();
		int[] nums = { 1, 2, 3, 4, 5, 7, 9 };
		int target = 10;
		System.out.println("result:" + b.leftBound(nums, target));
	}

}
