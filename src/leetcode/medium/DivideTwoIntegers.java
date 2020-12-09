package leetcode.medium;

public class DivideTwoIntegers {
	public int divide2(int dividend, int divisor) {
		// 判断overflow
		if (dividend == Integer.MIN_VALUE && divisor == -1) {
			return Integer.MAX_VALUE;
		}
		if (dividend == Integer.MIN_VALUE && divisor == 1) {
			return Integer.MIN_VALUE;
		}
		int count = 0;
		int sign = -1;
		if ((dividend >= 0 && divisor >= 0) || (dividend < 0 && divisor < 0)) {
			sign = 1;
		}
		if (sign == 1) {
			while (Math.abs(dividend) >= Math.abs(divisor)) {
				dividend -= divisor;
				count++;
			}
		} else {
			while (Math.abs(dividend) >= Math.abs(divisor)) {
				dividend += divisor;
				count++;
			}
		}
		if (sign == 1) {
			return count;
		} else {
			return -count;
		}
	}

	/**
	 * idea结合了位操作原理 同时，整体框架也是借鉴的
	 * 
	 * @param dividend
	 * @param divisor
	 * @return
	 */
	public int divide(int dividend, int divisor) {
		if( divisor == 0 ){
			return Integer.MAX_VALUE;
		}
		// 防止count overflow
		if (dividend == Integer.MIN_VALUE && divisor == -1) {
			return Integer.MAX_VALUE;
		}
		if (dividend == Integer.MIN_VALUE && divisor == 1) {
			return Integer.MIN_VALUE;
		}
		int count = 0, multiple = 0, temp = 0;
		/**
		 * 两个操作数进行异或时，对于同一位上，如果数值相同则为0，数值不同则为1，而计算机表示数值用反码，最高位是1的时候是负数，0为正数；
		 * 如果两者符号不一致，那么得到的最高位是1，即为负数
		 */
		int sign = (dividend ^ divisor) < 0 ? -1 : 1;
		if( divisor == Integer.MIN_VALUE && dividend == Integer.MIN_VALUE ){
			return 1;
		}
		// 防止Math.abs造成溢出
		if (dividend == Integer.MIN_VALUE) {
			if (divisor > 0) {
				dividend+=divisor;
				count++;
			} else {
				dividend-=divisor;
				count++;
			}
		}
		if( divisor == Integer.MIN_VALUE ){
			return 0;
		}
		int dvd = Math.abs(dividend),dvs = Math.abs(divisor);
		while (dvd >= dvs) {
			multiple = 1;
			temp = dvs;
			// 用平方来逼近答案，即dvd/(dvs*2^multiple)
			while (dvd - temp >= temp) { // dvd >= temp << 1 这样子写会溢出
				multiple <<= 1;
				temp <<= 1;
			}
			dvd -= temp;
			count += multiple;
		}
		return sign == 1 ? count : -count;
	}

	public static void main(String[] args) {
		DivideTwoIntegers s = new DivideTwoIntegers();
		int dividend = Integer.MIN_VALUE;
		int divisor = Integer.MIN_VALUE;
		int result = s.divide(dividend, divisor);
		System.out.println("result:" + result);
		System.out.println("isRight:" + (result == dividend / divisor));
	}
}
