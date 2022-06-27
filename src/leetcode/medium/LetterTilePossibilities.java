package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import leetcode.util.Util;

public class LetterTilePossibilities {
//	List<List<String>> res = new ArrayList<>();
	boolean used[];
	int sum = 0;

	/**
	 * 非空排列
	 * 
	 * @param tiles
	 * @return
	 */
	public int numTilePossibilities(String tiles) {
		String[] list = tiles.split("");
		Arrays.sort(list);
		used = new boolean[list.length];
//		Util.printArray(list);
		backtrack(list, new LinkedList<>());
//		Util.printListStr(res);
		return sum;
	}

	public void backtrack(String[] list, LinkedList<String> track) {
		if (track.size() != 0) {
			sum++;
//			res.add(new ArrayList<>(track));
		}
		for (int i = 0; i < list.length; i++) {
			if (used[i]) {
				continue;
			}
			if (i != 0 && list[i - 1].equals(list[i]) && !used[i - 1]) {
				continue;
			}
			track.add(list[i]);
			used[i] = true;
			backtrack(list, track);
			track.removeLast();
			used[i] = false;
		}
	}

	public static void main(String[] args) {
		LetterTilePossibilities l = new LetterTilePossibilities();
		String tiles = "AAABBC";
		Util.p(l.numTilePossibilities(tiles));
	}

}
