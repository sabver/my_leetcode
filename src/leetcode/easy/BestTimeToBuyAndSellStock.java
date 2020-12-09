package leetcode.easy;

/**
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 * 
 * If you were only permitted to complete at most one transaction (i.e., buy one
 * and sell one share of the stock), design an algorithm to find the maximum
 * profit.
 * 
 * Note that you cannot sell a stock before you buy one.
 * 
 * @author yejianfeng
 *
 */
public class BestTimeToBuyAndSellStock {

	public void print(Data[] dp) {
		String result = "";
		for (int i = 0; i < dp.length; i++) {
			if (i != dp.length - 1) {
				result += (dp[i] + ",");
			} else {
				result += (dp[i]);
			}
		}
		System.out.println(result);
	}

	public void print(Data[][] dp) {
		for (int i = 0; i < dp.length; i++) {
			print(dp[i]);
		}
	}

	/**
	 * 
	 * @param prices
	 * @param buy
	 *            buy是买的日子，从0开始，固定的
	 * @param hi
	 *            hi是右边边界
	 * @param dp
	 * @return
	 */
	public Data maxProfit(int[] prices, int buy, Data[][] dp, int hi) {
		// 交叉了
		if (buy >= hi) {
			return new Data(hi, 0);
		}
		// 已经计算过了就过
		if (dp[buy][hi] != null) {
			return dp[buy][hi];
		}
		Data yesDayData = maxProfit(prices, buy, dp, hi - 1);
		// 卖得了更高价，最大利益有可能增加
		if (prices[hi] >= prices[yesDayData.sellDay]) {
			// 增加多少？
			int maxProfix = yesDayData.profix + prices[hi] - prices[yesDayData.sellDay];
			Data data = new Data(hi, maxProfix);
			dp[buy][hi] = data;
			return data;
		} else {
			dp[buy][hi] = yesDayData;
			// 否则应该和昨天的最大利益一样
			return dp[buy][hi];
		}
	}

	public class Data {
		// public int buyDay;
		public int sellDay;
		public int profix;

		public Data(int sellDay, int profix) {
			// TODO Auto-generated constructor stub
			this.sellDay = sellDay;
			this.profix = profix;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "[sellDay" + sellDay + "," + profix + "]";
		}

	}

	/**
	 * 
	 * @param prices
	 * @return
	 */
	// public int maxProfit(int[] prices) {
	// int len = prices.length;
	// Data[][] dp = new Data[len][len];
	// int maxProfix = 0;
	// Data data = null;
	// // i是右边边界
	// for (int i = 0; i < len; i++) {
	// data = maxProfit(prices, i, dp, len - 1);
	// maxProfix = Math.max(maxProfix, data.profix);
	// }
	// print(dp);
	// return maxProfix;
	// }

	// public int maxProfit(int[] prices) {
	// int len = prices.length;
	// int[][] dp = new int[len][len];
	// int maxProfix = 0;
	// int maxProfixSellDay = -1;
	// // i是买的日子
	// for (int i = 0; i < len; i++) {
	// maxProfixSellDay = maxProfixSellDay(prices, i, dp, len - 1);
	// if (maxProfixSellDay != -1) {
	// maxProfix = Math.max(maxProfix, prices[maxProfixSellDay] - prices[i]);
	// }
	// }
	// return maxProfix;
	// }

	public int maxProfit(int[] prices) {
		int len = prices.length;
		int[] dp;
		int maxProfix = 0;
		int maxProfixSellDay = -1;
		int minBuyDay = 0;
		// i是买的日子，这里循环的时候应该可以找到一些不需要再遍历的点的
		for (int i = 0; i < len; i++) {
			dp = new int[len];
			maxProfixSellDay = maxProfixSellDay(prices, i, len - 1, dp);
			if (maxProfixSellDay != -1) {
				maxProfix = Math.max(maxProfix, prices[maxProfixSellDay] - prices[i]);
			}
		}
		return maxProfix;
	}

	// dp[i]定义为hi为边界的时候卖出的天数
	public int maxProfixSellDay(int[] prices, int buy, int hi, int[] dp) {
		// 交叉了
		if (buy >= hi) {
			return -1;
		}
		if (dp[hi] != 0) {
			return dp[hi];
		}
		int lastSellDay = maxProfixSellDay(prices, buy, hi - 1, dp);

		// 卖得了更高价，最大利益有可能增加
		if (lastSellDay != -1 && prices[hi] >= prices[lastSellDay]) {
			dp[hi] = hi;
			return hi;
		} else if (lastSellDay != -1 && prices[hi] < prices[lastSellDay]) {
			// 否则应该和昨天的最大利益一样
			dp[hi] = lastSellDay;
			return lastSellDay;
		} else {// if (lastSellDay == -1) 如果昨天的都没有卖的话
				// 有收益
			if (prices[hi] > prices[buy]) {
				dp[hi] = hi;
				return hi;
			} else {
				// 否则就还是没有必要卖了
				dp[hi] = -1;
				return -1;
			}
		}
	}

	// 这里改为返回应该在哪天卖，-1表示不卖
	// public int maxProfixSellDay(int[] prices, int buy, int[][] dp, int hi) {
	// // 交叉了
	// if (buy >= hi) {
	// return -1;
	// }
	// // 已经计算过了就过
	// if (dp[buy][hi] != 0) {
	// return dp[buy][hi];
	// }
	// int lastSellDay = maxProfixSellDay(prices, buy, dp, hi - 1);
	//
	// // 卖得了更高价，最大利益有可能增加
	// if (lastSellDay != -1 && prices[hi] >= prices[lastSellDay]) {
	// dp[buy][hi] = hi;
	// return hi;
	// } else if (lastSellDay != -1 && prices[hi] < prices[lastSellDay]) {
	// // 否则应该和昨天的最大利益一样
	// dp[buy][hi] = lastSellDay;
	// return dp[buy][hi];
	// } else{// if (lastSellDay == -1) 如果昨天的都没有卖的话
	// //有收益
	// if( prices[hi] > prices[buy] ){
	// dp[buy][hi] = hi;
	// return hi;
	// }else{
	// //否则就还是没有必要卖了
	// dp[buy][hi] = -1;
	// return -1;
	// }
	// }
	// }

	public static void main(String[] args) {
		BestTimeToBuyAndSellStock s = new BestTimeToBuyAndSellStock();
		int prices[] = { 7, 1, 5, 3, 6, 4 };
		// int prices[] = { 7, 6, 4, 3, 1 };
		System.out.println(s.maxProfit(prices));
	}
}
