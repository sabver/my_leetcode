package leetcode.medium;

public class PermutationSequence {
	class Data {
		public int value;

		Data(int value) {
			this.value = value;
		}
	}

	private Data one;
	private Data two;
	private Data three;
	private Data[][] threeOrder = new Data[6][3];

	private int count = 1;
	private int targetOrder;
	private String resultString = "";

	public void initThreeOrder() {
		one = new Data(1);
		two = new Data(2);
		three = new Data(3);
		// 1,2,3
		threeOrder[0][0] = one;
		threeOrder[0][1] = two;
		threeOrder[0][2] = three;
		// 1,3,2
		threeOrder[1][0] = one;
		threeOrder[1][1] = three;
		threeOrder[1][2] = two;
		// 2,1,3
		threeOrder[2][0] = two;
		threeOrder[2][1] = one;
		threeOrder[2][2] = three;
		// 2,3,1
		threeOrder[3][0] = two;
		threeOrder[3][1] = three;
		threeOrder[3][2] = one;
		// 3,1,2
		threeOrder[4][0] = three;
		threeOrder[4][1] = one;
		threeOrder[4][2] = two;
		// 3,2,1
		threeOrder[5][0] = three;
		threeOrder[5][1] = two;
		threeOrder[5][2] = one;
	}

	public void permute(int fixIndex, int[] nums) {
		if (this.resultString.length() != 0) {
			return;
		}
		if (fixIndex == nums.length - 3) {
			// 给后面三位数字进行排序
//			Arrays.sort(nums, fixIndex, nums.length);
			permuteThree(nums);
		} else {
			for (int i = fixIndex; i < nums.length; i++) {
				exchange(nums, i, fixIndex);
				permute(fixIndex + 1, nums);
				// 交换回去，避免出现不符合预期的顺序
				exchange(nums, i, fixIndex);
			}
		}
	}

	/**
	 * 通过固定的次序进行处理
	 * 
	 * @param nums
	 */
	public void permuteThree(int[] nums) {
		this.one.value = nums[nums.length - 3];
		this.two.value = nums[nums.length - 2];
		this.three.value = nums[nums.length - 1];
		// 此时，threeOrder已经获得了所有次序
		for (int i = 0; i < 6; i++) {
			System.out.println(this.count+":"+getResultString(nums, threeOrder[i]));
			if (this.targetOrder == this.count) {
				this.resultString = getResultString(nums, threeOrder[i]);
				return;
			}
			this.count++;
		}
	}

	public String getResultString(int[] nums, Data[] indexs) {
		StringBuffer result = new StringBuffer();
		for (int i = 0; i < nums.length - 3; i++) {
			result.append(nums[i]);
		}
		result.append(indexs[0].value);
		result.append(indexs[1].value);
		result.append(indexs[2].value);
		return result.toString();
	}

	/**
	 * 交换i和j的位置
	 * 
	 * @param nums
	 * @param i
	 * @param j
	 */
	public void exchange(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public String getPermutation(int n, int k) {
		if (n == 1) {
			return "1";
		}
		if (n == 2) {
			if (k == 1) {
				return "12";
			} else {
				return "21";
			}
		}
		this.targetOrder = k;
		int[] nums = new int[n];
		for (int i = 1; i <= n; i++) {
			nums[i - 1] = i;
		}
		initThreeOrder();
		permute(0, nums);
		return this.resultString;
	}

	public static void main(String[] args) {
		PermutationSequence s = new PermutationSequence();
		int n = 4;
		int k = 13;
		System.out.println(s.getPermutation(n, k));
	}
}
