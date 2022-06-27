package leetcode.medium;

public class FairDistributionOfCookies {
	int res = Integer.MAX_VALUE;
	int[] kids;
//	double diff = Double.MAX_VALUE;

	public int distributeCookies(int[] cookies, int k) {
		int[] kids = new int[k];
		backtrack(cookies, kids, 0);
		return res;
	}

	public void backtrack(int[] cookies, int[] kids, int start) {
		if (start == cookies.length) {
//			double curDiff = getDiff(kids);
//			if (curDiff < diff) {
//				// update
//				res = getMax(kids);
//				diff = curDiff;
//			}
			int max = getMax(kids);
			res = Math.min(max, res);
			return;
		}
		for (int i = 0; i < kids.length; i++) {
			kids[i] += cookies[start];
			backtrack(cookies, kids, start + 1);
			kids[i] -= cookies[start];
		}
	}

//	int getSum(int[] data) {
//		int sum = 0;
//		for (int i = 0; i < data.length; i++)
//			sum = sum + data[i];
//		return sum;
//	}
//
//	double getMean(int[] data) {
//		double mean = 0;
//		mean = getSum(data) / data.length;
//		return mean;
//	}
//
//	double getDiff(int[] data) {
//		double diff = 0;
//		for (int i = 0; i < data.length; i++) {
//			diff += Math.abs(data[i] - getMean(data));
//		}
//		return diff;
//	}
//
	int getMax(int[] data) {
		int max = data[0];
		for (int i = 1; i < data.length; i++) {
			max = Math.max(max, data[i]);
		}
		return max;
	}
}
