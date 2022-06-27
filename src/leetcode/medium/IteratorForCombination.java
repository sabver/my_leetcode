package leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class IteratorForCombination {
	class CombinationIterator {

		int combinationLength;
		Queue<String> res = new LinkedList<>();

		public CombinationIterator(String characters, int combinationLength) {
			this.combinationLength = combinationLength;
			String[] list = characters.split("");
			backtrack(list, 0, new StringBuffer());
		}

		public void backtrack(String[] list, int start, StringBuffer track) {
			if (track.length() == combinationLength) {
				res.offer(track.toString());
				return;
			}
			for (int i = start; i < list.length; i++) {
				track.append(list[i]);
				backtrack(list, i + 1, track);
				track.deleteCharAt(track.length() - 1);
			}
		}

		public String next() {
			return res.poll();
		}

		public boolean hasNext() {
			return !res.isEmpty();
		}
	}

}
