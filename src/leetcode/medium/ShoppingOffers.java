package leetcode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import leetcode.util.Util;

public class ShoppingOffers {
	int res = Integer.MAX_VALUE;
	Set<String> set = new HashSet<>();

	/**
	 * 把special的方案从0选到n，直到needs达到上限 具体步骤：special[0]选0到n，然后到special[1]，最后有余的选price
	 * 
	 * @param price
	 * @param special
	 * @param needs
	 * @return
	 */
	public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
		// 构建特殊的special
		// price = [2, 3, 4] => special: { [1, 0, 0, 2] [0, 1, 0, 3] [0, 0, 1, 4] }
		List<Integer> spec;
		int specLen;
		for (int i = 0; i < price.size(); i++) {
			specLen = price.size() + 1;
			spec = new ArrayList<>(specLen);
			for (int j = 0; j < specLen; j++) {
				if (j != specLen - 1) {
					spec.add(i == j ? 1 : 0);
				} else {
					spec.add(price.get(i));
				}
			}
			special.add(spec);
		}
		backtrack(special, needs, 0);
		return res;
	}

	public void backtrack(List<List<Integer>> special, List<Integer> needs, int totalPrice) {
		String key = needs.toString() + "," + totalPrice;
		if(set.contains(key)) {
			return;
		}
		boolean isAllNeed = true;
		for (Integer need : needs) {
			if (need != 0) {
				isAllNeed = false;
			}
			if (need < 0) {
				return;
			}
		}
		if (isAllNeed) {
			res = Math.min(totalPrice, res);
			return;
		}
		List<Integer> needsCopy;
		int price;
		for (List<Integer> spec : special) {
			needsCopy = new ArrayList<>(needs);
			// 做选择
			price = spec.get(spec.size() - 1);
			totalPrice += price;
			boolean isSkip = false;
			for (int i = 0; i < needs.size(); i++) {
				int val = needs.get(i) - spec.get(i);
				if( val < 0 ) {
					isSkip = true;
				}
				needs.set(i, val);
			}
			if( !isSkip ) {
				backtrack(special, needs, totalPrice);
			}
			// 撤销选择
			needs = needsCopy;
			totalPrice -= price;
		}
		set.add(key);
	}
	
    private int directPurchase(List<Integer> price, List<Integer> needs) {
    	int total = 0;
    	for (int i = 0; i < needs.size(); i++) {
    		total += price.get(i) * needs.get(i);
    	}
    	
    	return total;
    }

	public static void main(String[] args) {
		ShoppingOffers s = new ShoppingOffers();
		List<Integer> price = new ArrayList<>();
		List<List<Integer>> special = new ArrayList<>();
		List<Integer> needs = new ArrayList<>();
		price.add(2);
		price.add(5);
		List<Integer> spec1 = new ArrayList<>();
		spec1.add(3);
		spec1.add(0);
		spec1.add(5);
		List<Integer> spec2 = new ArrayList<>();
		spec2.add(1);
		spec2.add(2);
		spec2.add(10);
		special.add(spec1);
		special.add(spec2);
		needs.add(3);
		needs.add(2);
		Util.p(s.shoppingOffers(price, special, needs));
	}

}
