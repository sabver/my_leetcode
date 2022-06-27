package leetcode.medium;

import java.util.*;

public class ClosestDessertCost {
	int overTarget = Integer.MAX_VALUE, lowerTarget = Integer.MIN_VALUE;
	// 标记是否可以刚好cost等于target
	boolean flag;

	public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
		List<Integer> toppingCosts2 = new ArrayList<>();
		for (int i = 0; i < toppingCosts.length; i++) {
			toppingCosts2.add(toppingCosts[i]);
			toppingCosts2.add(toppingCosts[i]);
		}
		for (int i = 0; i < baseCosts.length; i++) {
			if (flag) {
				return target;
			}
			backtrack(toppingCosts2, 0, target, baseCosts[i]);
		}
		if (flag) {
			return target;
		}
		int absOver = Math.abs(overTarget - target), absLower = Math.abs(lowerTarget - target);
		if (absOver >= absLower || absOver > absLower) {
			return lowerTarget;
		} else {
			return overTarget;
		}
	}

	public void backtrack(List<Integer> toppingCosts, int start, int target, int cost) {
		if (flag) {
			return;
		}
		if (cost == target) {
			flag = true;
		} else if (cost > target) {
			overTarget = Math.min(cost, overTarget);
		} else {
			lowerTarget = Math.max(cost, lowerTarget);
		}
		if (start >= toppingCosts.size()) {
			return;
		}
		for (int i = start; i < toppingCosts.size(); i++) {
			cost += toppingCosts.get(i);
			backtrack(toppingCosts, i + 1, target, cost);
			cost -= toppingCosts.get(i);
		}
	}

}
