package leetcode.medium;
/**
 * 用1的实现好像比较麻烦，所以，这里要用优化版的动态规划
 * @author yejianfeng
 *
 */
public class UniquePathsII {
	/**
	 * the shortest answer in the discussion of leetcode 
	 * @param obstacleGrid
	 * @return
	 */
	public int uniquePathsWithObstaclesLeetcode(int[][] obstacleGrid) {
	    int width = obstacleGrid[0].length;
	    int[] dp = new int[width];
	    dp[0] = 1;
	    for (int[] row : obstacleGrid) {
	        for (int j = 0; j < width; j++) {
	            if (row[j] == 1)
	                dp[j] = 0;
	            else if (j > 0)
	                dp[j] += dp[j - 1];
	        }
	    }
	    return dp[width - 1];
	}	
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		return uniquePathsWithObstacles(obstacleGrid, obstacleGrid.length, obstacleGrid[0].length);
	}

	/**
	 * 动态规划版本会超时
	 * @param obstacleGrid
	 * @param row
	 *            从1开始
	 * @param col
	 *            从1开始
	 * @return
	 */
	public int uniquePathsWithObstacles(int[][] obstacleGrid, int row, int col) {
		//如果当前是障碍
		if( obstacleGrid[row-1][col-1] == 1 ){
			return 0;
		}
		if (row == 1 && col == 1) {
			return 1;
		}		
		if (row == 1) {
			return uniquePathsWithObstacles(obstacleGrid, row, col - 1);
		}
		if (col == 1) {
			return uniquePathsWithObstacles(obstacleGrid, row - 1, col);
		}
		return uniquePathsWithObstacles(obstacleGrid, row - 1, col)
				+ uniquePathsWithObstacles(obstacleGrid, row, col - 1);
	}
	

	public static void main(String[] args) {
		UniquePathsII s = new UniquePathsII();
		int[][] obstacleGrid = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
		System.out.println(s.uniquePathsWithObstacles(obstacleGrid));
	}
}
