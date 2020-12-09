package leetcode.easy;

public class RemoveElement {
	public void print(int[] nums) {
		String result = "";
		for (int i = 0; i < nums.length; i++) {
			result += (nums[i] + " ");
		}
		System.out.println(result);
	}

	/**
	 * @param nums
	 * @param val
	 * @param curIndex
	 * @return
	 */
	public int findNextNotSameIndex(int[] nums, int val, int curIndex) {
		System.out.println("curIndex:" + curIndex);
		for (int i = curIndex; i < nums.length; i++) {
			if (nums[i] != val) {
				return i;
			}
		}
		return nums.length;
	}

	public int removeElement3(int[] nums, int val) {
		if (nums.length == 1 && nums[0] == val) {
			nums = new int[0];
		}
		if (nums.length == 0 || nums.length == 1) {
			return nums.length;
		}
		int index = 0;
		// 统计答案
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != val) {
				index++;
			}
		}
		int notSameIndex = 0;
//		if (nums[0] == val) {
//			notSameIndex = 1;
//		}
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == val) {
				notSameIndex = findNextNotSameIndex(nums, val, notSameIndex + 1);
//				 System.out.println("notSameIndex after:"+notSameIndex);
				// 后面都是相同的，直接结束
				if (notSameIndex == nums.length) {
					break;
				}
				nums[i] = nums[notSameIndex];
				nums[notSameIndex] = val;
			} else {
				notSameIndex = i;
			}
//			 System.out.println("notSameIndex:" + notSameIndex);
//			 System.out.println("");
		}
		return index;
	}

	/**
	 * Runtime: 10 ms 49.83%
	 * 
	 * @param nums
	 * @param val
	 * @return
	 */
	public int removeElement2(int[] nums, int val) {
		int beginIndex = 0;
		int notSameIndex = 0;
		int index = 0;
		// 统计答案
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != val) {
				index++;
			}
		}
		for (int i = beginIndex; i < nums.length; i++) {
			if (nums[i] == val) {
				notSameIndex = findNextNotSameIndex(nums, val, i);
				// System.out.println("sameIndex:"+sameIndex);
				// 后面都是相同的，直接结束
				if (notSameIndex == nums.length) {
					break;
				}
				nums[i] = nums[notSameIndex];
				nums[notSameIndex] = val;
				// i = sameIndex;
			}
		}
		return index;
	}
	public int removeElement(int[] nums, int val) {
		int count = 0;
		int endIndex = nums.length - 1;
		int beginIndex = 0;
		while( endIndex >= beginIndex ){
			if( nums[beginIndex] == val && nums[endIndex]!=val ){
				nums[beginIndex] = nums[endIndex];
				nums[endIndex] = val;
				endIndex--;
				beginIndex++;
				count++;
			}
			if( nums[beginIndex] != val ){
				beginIndex++;
				count++;
			}
			if( nums[endIndex] == val ){
				endIndex--;
			}
		}
		return count;
	}
	public static void main(String[] args) {
		RemoveElement s = new RemoveElement();
		int[] nums = { 4, 5 };
		s.print(nums);
		System.out.println(s.removeElement(nums, 4));
		s.print(nums);
	}
}
