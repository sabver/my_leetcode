package leetcode.easy;

public class ClimbingStairs {
	public int climbStairs(int n) {
		if( n == 1 ){
			return 1;
		}
		if( n == 2 ){
			return 2;
		}
		int[] records = new int[n + 1];
		records[0] = 0;
		records[1] = 1;
		records[2] = 2;
		for (int i = 3; i <= n; i++) {
			records[i] = records[i - 2] + records[i - 1];
		}
//		print(records);
		return records[n];
	}

	public void print(int[] records) {
		String str = "";
		for (int i = 0; i < records.length; i++) {
			str += (records[i] + " ");
		}
		System.out.println(str);
	}

	public static void main(String[] args) {
		ClimbingStairs s = new ClimbingStairs();
		System.out.println(s.climbStairs(3));
	}
}
