package leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import leetcode.util.Util;

public class CircularPermutationInBinaryRepresentation {

	List<Integer> res = new ArrayList<>();
	boolean used[];
	int n, start, max;

	public List<Integer> circularPermutation(int n, int start) {
		this.n = n;
		this.start = start;
		this.max = (int) Math.pow(2, n);
//		int[] init = getInitBinaryArray(n, start);
		used = new boolean[this.max];
		LinkedList<Integer> track = new LinkedList<>();
		track.add(start);
		used[start] = true;
		dfs(start, track);
		return res;
	}

	public boolean dfs(int start, LinkedList<Integer> track) {
		if (track.size() == this.max) {
			int last = track.getLast();
			// 如果只差一位的，那就是x是全部是1
			int x = last ^ this.start;
			if ((x & (x - 1)) == 0) {
				res = new ArrayList<>(track);
				return true;
			}
			return false;
		}
		for (int i = 0; i < n; i++) {
			int next = start ^ (1 << i);
			if (used[next]) {
				continue;
			}
			used[next] = true;
			track.add(next);
			if (dfs(next, track))
				return true;
			used[next] = false;
			track.removeLast();
		}
		return false;
	}

	public int[] getInitBinaryArray(int n, int start) {
		int[] res = new int[n];
		for (int i = n - 1; i >= 0; i--) {
			if (start == 0) {
				break;
			}
			int cur = start % 2;
			res[i] = cur;
			start = (start - cur) / 2;
		}
		return res;
	}

	public int getNumFromBinaryArray(int[] res) {
		int sum = 0;
		for (int i = res.length - 1; i >= 0; i--) {
			if (res[i] != 0) {
				sum += Math.pow(2, res.length - 1 - i);
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		CircularPermutationInBinaryRepresentation a = new CircularPermutationInBinaryRepresentation();
		int n = 3, start = 2;
		int res[] = a.getInitBinaryArray(n, start);
		Util.printArray(res);
		Util.p(a.getNumFromBinaryArray(res));
		Util.p(a.circularPermutation(n, start));
	}

}
