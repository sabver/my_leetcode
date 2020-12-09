package leetcode.medium;

import java.util.*;

/**
 * 基础顺序是: 0 1
 * 
 * 如果加多一位0的话，就顺序加入，加入1的话，就倒序加入 如: 00 01 11 10
 * 
 * 依次类推
 * 
 * 
 * 第二种表达方式：
 * Bn-1Bn-2...B2B1B0 某二进制数字
 * Gn-1Gn-2...G2G1G0 对应的gray code
 * 
 * 最高位保留
 * 其他的：Gi=Bi+1^Bi,i=0,1,2...n-2
 * @author yejianfeng
 *
 */
public class GrayCode {
	public List<Integer> grayCode(int n) {
		List<Integer> result = new ArrayList<Integer>();
		if (n == 0) {
			result.add(0);
			return result;
		}
		if (n == 1) {
			result.add(0);
			result.add(1);
			return result;
		}
		// n的结果是根据n-1的结果的
		List<Integer> lastResult = grayCode(n - 1);
		int len = lastResult.size();
		for (int i = len - 1; i >= 0; i--) {
			lastResult.add(lastResult.get(i) + (1 << n - 1));
		}
		return lastResult;
	}

	/**
	 * leetcode上的例子
	 * 
	 * @param n
	 * @return
	 */
	public List<Integer> grayCode2(int n) {
		List<Integer> result = new ArrayList<>();

		for (int i = 0; i < 1 << n; i++) {
			System.out.println(i + " " + (i >> 1) + " " + (i >> 1 ^ i));
			result.add(i ^ i >> 1);
		}

		return result;
	}

	public static void main(String[] args) {
		GrayCode s = new GrayCode();
		int n = 3;
		System.out.println(s.grayCode2(n));
		// System.out.println(3^7);
		// System.out.println(1^1);
		// System.out.println(0^1<<1);
	}
}
