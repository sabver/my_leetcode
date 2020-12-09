package leetcode.medium;

public class DecodeWays {
	public int numDecodings(String s) {
		int len = s.length();
		if (len == 0) {
			return 0;
		}
		char[] nums = s.toCharArray();
		// 检查是否存在无法解码的情况
		if (nums[0] == '0') {
			return 0;
		}
		for (int i = 1; i < len; i++) {
			if (nums[i] == '0' && (((nums[i - 1] - 48) > 2) || nums[i - 1] == '0')) {
				return 0;
			}
		}
		// 最后一位字母没有和前面字母结合的数量
		int notCombinateNum = 1;
		// 最后一位字母和前面字母结合的数量
		int combinateNum = 0;
		// 临时变量
		int tempNotCombinateNum = 0;
		int tempCombinateNum = 0;
		for (int i = 1; i < len; i++) {
			// 如果当前是0，那么它只能和前面结合
			if (nums[i] == '0') {
				// 这时因为0本身只能组成10或20，所以它的结合数和前者的不结合数一样
				combinateNum = notCombinateNum;
				// 不结合的数量为0，由于0的存在，这里导致前面的一些结合情况清空了，因为前面已经结合的话，那么单独留下0会无法解读
				notCombinateNum = 0;
			} else {
				int num = (nums[i - 1] - 48) * 10 + (nums[i] - 48);
				tempNotCombinateNum = notCombinateNum;
				tempCombinateNum = combinateNum;
				// 如果当前是可以前者结合的
				if (num <= 26) {
					// 可以结合的话，那么现在结合数量就是等于前者的未结合数量
					combinateNum = tempNotCombinateNum;
					// 那么剩下的未结合数量就是等于前者的已结合数量加上未结合数量
					notCombinateNum = tempNotCombinateNum + tempCombinateNum;
				} else {
					// 如果不可以结合的话，那么现在结合的数量变为0
					combinateNum = 0;
					// 同时，不结合的数量就是前者的不结合数加结合数
					notCombinateNum = tempCombinateNum + tempNotCombinateNum;
				}
			}
		}
		return notCombinateNum + combinateNum;
	}

	public static void main(String[] args) {
		DecodeWays s = new DecodeWays();
		String str = "1111";
		System.out.println(s.numDecodings(str));
	}
}
