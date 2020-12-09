package leetcode.medium;

public class SearchA2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix.length == 0) {
			return false;
		}
		if (matrix[0].length == 0) {
			return false;
		}
		int targetRow = searchSection(matrix, 0, 0, matrix.length - 1, target);
		if (targetRow == -1) {
			return false;
		}
		if (matrix[targetRow][0] == target) {
			return true;
		}
		if (targetRow < matrix.length - 1 && matrix[targetRow + 1][0] == target) {
			return true;
		}
		if (binarySearch(matrix[targetRow], 0, matrix[targetRow].length - 1, target) == -1) {
			return false;
		}
		return true;
	}

	public int binarySearch(int[] array, int low, int high, int target) {
		if (low > high) {
			return -1;
		}
		int mid = (low + high) / 2;
		if (array[mid] == target) {
			return mid;
		} else if (array[mid] > target) {
			return binarySearch(array, low, high - 1, target);
		} else {
			return binarySearch(array, low + 1, high, target);
		}
	}

	public int searchSection(int[][] matrix, int colIndex, int low, int high, int target) {
		if (low > high) {
			return -1;
		}
		int mid = (low + high) / 2;
		int cur = matrix[mid][colIndex];
		if (((mid < matrix.length - 1) && (cur <= target && matrix[mid + 1][colIndex] >= target))
				|| (mid == matrix.length - 1 && cur <= target)) {
			return mid;
		} else if (cur > target) {
			return searchSection(matrix, colIndex, low, high - 1, target);
		} else if (mid < matrix.length - 1 && matrix[mid + 1][colIndex] < target) {
			return searchSection(matrix, colIndex, low + 1, high, target);
		} else if (mid == matrix.length - 1 && cur < target) {
			return -1;
		} else {
			return -1;
		}
	}

	/**
	 * 检索区间，返回结果i要求：array[i]<=target<=array[i+1]，如果不存在该区间，return-1
	 * 
	 * @param array
	 * @param low
	 * @param high
	 * @param target
	 * @return
	 */
	public int searchSection(int[] array, int low, int high, int target) {
		if (low > high) {
			return -1;
		}
		int mid = (low + high) / 2;
		if (((mid < array.length - 1) && (array[mid] <= target && array[mid + 1] >= target))
				|| (mid == array.length - 1 && array[mid] <= target)) {
			return mid;
		} else if (array[mid] > target) {
			return searchSection(array, low, high - 1, target);
		} else if (mid < array.length - 1 && array[mid + 1] < target) {
			return searchSection(array, low + 1, high, target);
		} else if (mid == array.length - 1 && array[mid] < target) {
			return -1;
		} else {
			return -1;
		}
	}

	public void test() {
		int target = 3;
		int[] array = { 3, 4, 5, 6, 7, 11, 14, 16, 20 };
		System.out.println(searchSection(array, 0, array.length - 1, target));
		// int[][] matrix = { { 3 }, { 4 }, { 5 }, { 6 }, { 7 }, { 11 }, { 14 },
		// { 16 }, { 20 } };
		int[][] matrix = { { 1 }, { 3 } };
		System.out.println(searchSection(matrix, 0, 0, matrix.length - 1, target));
	}

	public static void main(String[] args) {
		SearchA2DMatrix s = new SearchA2DMatrix();
		int[][] matrix = {};
		int target = 2;
		System.out.println(s.searchMatrix(matrix, target));
		s.test();

	}
}
