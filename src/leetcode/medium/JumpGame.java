package leetcode.medium;

public class JumpGame {
	public boolean canJump(int[] nums) {
		if (nums.length <= 1) {
			return true;
		}
		int start = 0;
		int end = 1;
		int canJump = canJump(nums, start, end);
		while (canJump != -1) {
			if (canJump >= nums.length - 1) {
				return true;
			}
			// 如果被卡在同一个位置了
//			if (start == canJump && nums[canJump] == 0) {
//				return false;
//			}
			start = end;
			end = canJump + 1;
			canJump = canJump(nums, start, end);
		}
		return false;
	}

	/**
	 * 判断是否能从start跳跃到end
	 * 
	 * @param nums
	 * @param start
	 * @param end
	 *            待定判断的值
	 * @return
	 */
	public int canJump(int[] nums, int start, int end) {
		int canJumpPosition = howFarCanJump(nums, start, end);
		// 如果在start到end-1这段里面的最大跳跃距离无法越过end的话，就无法到达终点
		int result = canJumpPosition < end ? -1 : canJumpPosition;
		System.out.println("start:" + start + " end:" + end + " canJumpPosition:" + canJumpPosition);
		return result;
	}

	/**
	 * 计算从start到end-1这段距离中，能跳跃的最远距离
	 * 
	 * @param nums
	 * @param start
	 * @param end
	 * @return
	 */
	public int howFarCanJump(int[] nums, int start, int end) {
		int max = start + nums[start];
		for (int i = start + 1; i < end; i++) {
			max = Math.max(i + nums[i], max);
		}
		return max;
	}

	public static void main(String[] args) {
		JumpGame s = new JumpGame();
//		int[] nums = { 2, 3, 1, 1, 4 };
//		int[] nums2 = { 3, 2, 1, 0, 4 };
//		int[] nums3 = { 1 };
//		int[] nums4 = { 2, 5, 0, 0 };
		int[] nums5 = { 1, 1, 2, 2, 0, 1, 1 };
		System.out.println(s.canJump(nums5));
	}
}
