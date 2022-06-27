package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class GrayCodeV2 {
	List<Integer> res = new ArrayList<>();
	boolean[] used;
	int n;

	public List<Integer> grayCode(int n) {
		this.n = n;
		List<Integer> arr = new ArrayList<>(n);
		for (int i = 0; i < n; i++) {
			arr.add(0);
		}
		used = new boolean[(int) Math.pow(2, n)];
		used[0] = true;
		backtrack(n, arr);
		return res;
	}

	public void backtrack(int n, List<Integer> arr) {
		res.add(getCur(arr));
		// 旋转arr里面的每一位
		for (int i = 0; i < n; i++) {
			int value = arr.get(i);
			int nextValue = value == 1 ? 0 : 1;
			int next = getNext(arr, i, nextValue);
			if (used[next] == false) {
				arr.set(i, nextValue);
				used[next] = true;
				backtrack(n, arr);
//				arr.set(i, value);
//				used[next] = false;
			}
		}
	}

	public int getCur(List<Integer> arr) {
		int sum = 0;
		for (int i = n - 1; i >= 0; i--) {
			sum += arr.get(i) * Math.pow(2, n - i - 1);
		}
		return sum;
	}

	public int getNext(List<Integer> arr, int index, int value) {
		int sum = 0;
		for (int i = n - 1; i >= 0; i--) {
			if (i == index) {
				sum += value * Math.pow(2, n - i - 1);
			} else {
				sum += arr.get(i) * Math.pow(2, n - i - 1);
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		GrayCodeV2 g = new GrayCodeV2();
		int n = 2;
		List<Integer> res = g.grayCode(n);
		System.out.println(res);
	}

}
