package leetcode.medium;

public class ZigZagConversion {

	public String convert(String s, int numRows) {
		int length = s.length();
		// System.out.println("length:"+length);
		if (numRows <= 1) {
			return s;
		}
		if (length <= 1) {
			return s;
		}
		// 每一项有多少个元素
		int numItems = 2 * numRows - 2;
		int numColumns = (int) Math.ceil((double) length / (double) numItems);
		// 不从0开始
		int count = 1;
		int countRow = 0;
		int countCol = 0;
		// 不从0开始,indexs的值如果为0，就是空格
		int indexs[][] = new int[numRows + 1][numColumns * (numRows - 1) + 1];
		// System.out.println("numRows:" + numRows);
		// System.out.println("numColumns:" + numColumns);
		// System.out.println("indexs_rows:" + indexs.length);
		// System.out.println("indexs_cols:" + indexs[0].length);
		for (int i = 1; i <= numColumns; i++) {
			countCol = (i - 1) * (numRows - 1) + 1;
			// 先处理第一列
			for (int j = 1; j <= numRows; j++) {
				// System.out.println("j:" + j + "countCol:" + countCol);
				indexs[j][countCol] = count;
				count++;
			}
			countRow = numRows - 1;
			countCol++;
			while (countRow > 1 && countCol < i * (numRows - 1) + 1) {
				// System.out.println("countRow:" + countRow);
				// System.out.println("countCol:" + countCol);
				indexs[countRow][countCol] = count;
				count++;
				countRow--;
				countCol++;
			}
			// System.out.println();
		}
		print(s, indexs);
		// 不知道为什么leetcode用这个会出现编码异常
		// char[] chars = new char[length];
		// count = 0;
		StringBuffer result = new StringBuffer();
		// 读取字符
		for (int i = 1; i < indexs.length; i++) {
			for (int j = 1; j < indexs[i].length; j++) {
				if (indexs[i][j] != 0 && indexs[i][j] <= length) {
					// chars[count++] = s.charAt(indexs[i][j] - 1);
					result.append(s.charAt(indexs[i][j] - 1));
				}
			}
		}
		return result.toString();
		// return String.valueOf(chars);
	}

	public void print(String s, int indexs[][]) {
		String str = "";
		for (int i = 0; i < indexs.length; i++) {
			str = "";
			for (int j = 0; j < indexs[i].length; j++) {
				if (indexs[i][j] < 10) {
					str += ("0" + indexs[i][j] + " ");
				} else {
					str += (indexs[i][j] + " ");
				}

			}
			System.out.println(str);
		}
	}

	public static void main(String[] args) {
		ZigZagConversion s = new ZigZagConversion();
		String str = "ABCD";
		int numRows = 3;
		System.out.println(s.convert(str, numRows));
	}
}
