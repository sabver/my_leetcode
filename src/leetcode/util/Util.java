package leetcode.util;

import java.util.List;

import leetcode.medium.PrintBinaryTree;

/**
 * 定义一个工具类
 * 
 * @author yejianfeng
 *
 */
public class Util {
	/**
	 * 生成一个数量为number的随机数组，里面元素最小值为max，最小值大于0
	 * 
	 * @param number
	 *            需要生成的数组的数量
	 * @param max
	 *            数组里面的最大元素
	 * @return 一个数量为number的随机数组
	 */
	public static int[] createRandomArray(int number, int max) {
		// 定义好一个长度为number的空数组
		int[] result = new int[number];
		for (int i = 0; i < number; i++) {
			result[i] = (int) Math.ceil(Math.random() * max);
		}
		return result;
	}
	
	/**
	 * 打印里面的数组元素
	 * 
	 * @param array
	 */
	public static void printArray(double[] array) {
		String result = "[";
		for (int i = 0; i < array.length; i++) {
			if (i != array.length - 1) {
				result += (array[i] + ",");
			} else {
				result += (array[i]);
			}
		}
		System.out.println(result + "]");
	}

	/**
	 * 打印里面的数组元素
	 * 
	 * @param array
	 */
	public static void printArray(int[] array) {
		String result = "[";
		for (int i = 0; i < array.length; i++) {
			if (i != array.length - 1) {
				result += (array[i] + ",");
			} else {
				result += (array[i]);
			}
		}
		System.out.println(result + "]");
	}

	public static void printArray(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			printArray(array[i]);
		}
	}

	/**
	 * 打印从p到r的数组元素
	 * 
	 * @param array
	 *            需要打印的数组
	 * @param p
	 *            开始索引
	 * @param r
	 *            结束索引
	 */
	public static void printArray(int[] array, int p, int r) {
		String result = "";
		for (int i = p; i <= r; i++) {
			if (i != array.length - 1) {
				result += (array[i] + ",");
			} else {
				result += (array[i]);
			}
		}
		System.out.println(result);
	}

	public static void printList(List<List<Integer>> result) {
		System.out.println("size:" + result.size());
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}
	}
	
	public static void printListStr(List<List<String>> result) {
		System.out.println("size:" + result.size());
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}
	}
	
	public static void printBinaryTree(TreeNode root) {
		PrintBinaryTree p = new PrintBinaryTree();
		p.printTree(root);
	}
	
}
