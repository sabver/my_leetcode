package leetcode.easy;

public class ReverseInteger {
	public int reverse(int x) {
		int result = 0;
		int num = 0;
		int y = 0;
		while (x != 0) {
			y = result;
			num = x % 10;
			result = result * 10 + num;
			// 防止溢出
			if ((result - num) / 10 != y) {
				return 0;
			}
			x = (x - num) / 10;
		}
		return result;
	}

	public int reverse3(int x) {
		int result = 0;
		int maxTenMap = 1000000000;
		int tenMap = maxTenMap;
		int tenReverse = 1;
		int num = 0;
		boolean beginCount = false;
		int nextNumber = 0;
		while (tenMap != 0) {
			num = x / tenMap;
			if (num != 0) {
				beginCount = true;
			}
			// 判断越界
			if ((num > 2 || num < -2) && maxTenMap == tenReverse) {
				return 0;
			}
			nextNumber = num * tenReverse;
			// 如果接下来相加会越界
			if (x > 0 && (Integer.MAX_VALUE - result) < nextNumber) {
				return 0;
			}
			if (x < 0 && (Integer.MIN_VALUE - result) > nextNumber) {
				return 0;
			}
			result += nextNumber;
			x -= num * tenMap;
			tenMap = tenMap / 10;
			if (beginCount) {
				tenReverse = tenReverse * 10;
			}
		}
		return result;
	}

	public int reverse2(int x) {
		// System.out.println(x);
		// System.out.println(Integer.MAX_VALUE);
		// System.out.println(Integer.MIN_VALUE);
		if (x == Integer.MAX_VALUE || x == Integer.MIN_VALUE) {
			return 0;
		}
		// 保留符号
		int signed = x < 0 ? -1 : 1;
		String numStr = x * signed + "";
		// System.out.println(numStr);
		int result = 0;
		// 10的0次方
		int tenMap = 1;
		int nextPlusNumber = 0;
		// 这里直接判断tenMap越界的情况
		if (Integer.valueOf(numStr.charAt(numStr.length() - 1) + "") > 2 && numStr.length() == 10) {
			return 0;
		}
		for (int i = 0; i < numStr.length(); i++) {
			// 这里在计算的过程中会出现溢出，需要检测
			nextPlusNumber = Integer.valueOf(numStr.charAt(i) + "") * tenMap;
			// 如果接下来添加的值会溢出就退出
			if (signed == 1 && Integer.MAX_VALUE - result < nextPlusNumber) {
				return 0;
			}
			if (signed == -1 && (Integer.MIN_VALUE + result) > -nextPlusNumber) {
				// System.out.println("result:" + result);
				// System.out.println((Integer.MIN_VALUE + result) * -1);
				// System.out.println("bingo");
				return 0;
			}
			result = result + nextPlusNumber;
			tenMap = tenMap * 10;
		}
		return result * signed;
	}

	public static void main(String[] args) {
		ReverseInteger ri = new ReverseInteger();
		// -1563847412
		System.out.println(ri.reverse(-123));
	}
}
