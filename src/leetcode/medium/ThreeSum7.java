package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ThreeSum7 {
	// 调试用的变量
	// private int breakNumOne = 0;
	// private int binaryNumOne = 0;
	// private int breakNumTwo = 0;
	// private int binaryNumTwo = 0;

	// 修正数
	private int fixNum = 0;

	public List<List<Integer>> threeSum(int[] nums) {
		// 先排序 默认从小到大
		Arrays.sort(nums);
//		printNums(nums);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		// 小于3就不用找答案了
		if (nums.length < 3) {
			return result;
		}
		// 只有一个答案的情况
		if (nums.length == 3 && nums[0] + nums[1] + nums[2] == 0) {
			result.add(createList(nums[0], nums[1], nums[2]));
			return result;
		}
		// 前三个已经加起来大于0的情况
		if (nums[0] + nums[1] + nums[2] > 0) {
			return result;
		}
		// 都是零的情况
		if (nums[0] == 0 && nums[nums.length - 1] == 0) {
			result.add(createList(0, 0, 0));
			return result;
		}
		// 都是正数或者负数的情况
		if (nums[0] > 0 || nums[nums.length - 1] < 0) {
			return result;
		}
		// long time = System.currentTimeMillis();
		// 做数组预处理，提炼出所有[a,a,-2a]和[-a,-a,2a]的情况，将数组的重复元素去掉
		nums = threeSumDeleteSame(nums, result);
		// System.out.println("handled nums length:" + nums.length);
//		printNums(nums);
		// System.out.println("pre handle runtime:" +
		// (System.currentTimeMillis() - time));
		int sum = 0;
		int target = 0;
		int index = 0;
		// time = System.currentTimeMillis();
		// 获取起点，它的另外一个作用是锚点
		int startIndex = findStartIndex(nums);
//		System.out.println("startIndex:" + startIndex + " value:" + nums[startIndex]);
		// 备份起点的值
		int originStartIndex = startIndex;
		// 如果起点不是0，那么需要修正
		if (nums[startIndex] != 0) {
			// 这时，问题就变成了要找三个数的合为3*fixNum
			// 修正了之后，其实整体性质不变，因为答案依旧是分布在[0...startIndex-1]和[startIndex...nums.length-1]之间
			this.fixNum = -nums[startIndex];
			// 修正数组
			fixNums(nums);
//			System.out.println();
//			System.out.println("fixed nums:");
//			printNums(nums);
//			System.out.println("fixNum:" + this.fixNum);
//			System.out.println();
		}
		// 用hashtable来提高检索速度，这时候的map是没有重复元素的
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(nums.length / 2);
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}
		// System.out.println("getStartIndex runtime:" +
		// (System.currentTimeMillis() - time));
		// System.out.println();
		// 相对于锚点的游标
		int pointerIndex = originStartIndex - 1;
		// time = System.currentTimeMillis();
		// 首先假设有两个解在[0...startIndex-1]，一个解在[startIndex...nums.length-1]
		while (startIndex <= nums.length - 1) {
			// 排除极端情况，这个条件没有意义
			// if (2 * nums[0] + nums[startIndex] > 3 * this.fixNum) {
			// System.out.println("one breakall:" + startIndex);
			// break;
			// }
			// if( 2 * nums[pointerIndex] + nums[startIndex] > 3 * this.fixNum
			// ){
			// System.out.println("one breakall:" + startIndex);
			// break;
			// }
			while (pointerIndex >= 0) {
				// 由于这里是固定了锚点，而游标指向的值会不断减少，如果这时候已经它们的和已经小于0，那么就不用再找了
				sum = nums[startIndex] + nums[pointerIndex];
				if (sum < 3 * this.fixNum) {
					// this.breakNumOne++;
					break;
				}
				// this.binaryNumOne++;
				target = 3 * this.fixNum - sum;
				// 如果存在答案才进行二分检索
				if (map.containsKey(target)) {
					// 查询答案
					// index = binarySearch(nums, target, 0, pointerIndex - 1);
					// index = startIndex;
					index = map.get(target);
					// 正数都放到前面
					// && isHaveSame(result, nums[startIndex],
					// nums[pointerIndex], nums[index]) == false
					if (index <= pointerIndex - 1) {
						result.add(createList(nums[startIndex] - this.fixNum, nums[pointerIndex] - this.fixNum,
								nums[index] - this.fixNum));
					}
				}
				pointerIndex--;
			}
			startIndex++;
			pointerIndex = originStartIndex - 1;
		}
		// System.out.println("breakNumOne:" + breakNumOne);
		// System.out.println("binaryNumOne:" + binaryNumOne);
		// System.out.println("findOne runtime:" + (System.currentTimeMillis() -
		// time));
		// System.out.println();
		// time = System.currentTimeMillis();
		// 先测试上面的答案
		// if (true) {
		// return result;
		// }
		// 最后假设有一个解在[0...startIndex-1]，两个解在[startIndex...nums.length-1]
		// 这时，pointerIndex和startIndex的作用要反过来
		startIndex = originStartIndex;
		pointerIndex = originStartIndex - 1;
		// 先固定pointerIndex，再移动startIndex
		while (pointerIndex >= 0) {
			// 排除极端情况，这个条件没有意义
			// if (2 * nums[nums.length - 1] + nums[pointerIndex] < 3 *
			// this.fixNum) {
			// System.out.println("two breakall:" + pointerIndex);
			// break;
			// }
			// if( 2 * nums[startIndex] + nums[pointerIndex] < 3 * this.fixNum
			// ){
			// System.out.println("two breakall:" + pointerIndex);
			// break;
			// }
			while (startIndex <= nums.length - 1) {
				// 这里是固定了pointerIndex，而startIndex指向的值会不断增大，如果这时候它们的和已经大于0，那么就不用再找了
				sum = nums[startIndex] + nums[pointerIndex];
				if (sum > 3 * this.fixNum) {
					// this.breakNumTwo++;
					break;
				}
				// this.binaryNumTwo++;
				target = 3 * this.fixNum - sum;
				// 如果存在答案才进行二分检索
				if (map.containsKey(target)) {
					// 查询答案
					// index = binarySearch(nums, target, startIndex + 1,
					// nums.length - 1);
					index = map.get(target);
					// index = startIndex;
					// 正数都放到前面
					// && isHaveSame(result, nums[startIndex], nums[index],
					// nums[pointerIndex]) == false
					if (index >= startIndex + 1) {
						result.add(createList(nums[startIndex] - this.fixNum, nums[index] - this.fixNum,
								nums[pointerIndex] - this.fixNum));
					}
				}
				startIndex++;
			}
			pointerIndex--;
			startIndex = originStartIndex;
		}
		// System.out.println("breakNumTwo:" + breakNumTwo);
		// System.out.println("binaryNumTwo:" + binaryNumTwo);
		// System.out.println("findTwo runtime:" + (System.currentTimeMillis() -
		// time));
		// System.out.println();
		return result;
	}

	public void fixNums(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			nums[i] += this.fixNum;
		}
	}

	/**
	 * 排除掉相同的元素，这里是未修正前的
	 * 
	 * @param nums
	 * @param result
	 * @return
	 */
	public int[] threeSumDeleteSame(int[] nums, List<List<Integer>> result) {
		// 用hashtable来统计出现次数
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(nums.length);
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i]) == false) {
				map.put(nums[i], 1);
			} else {
				map.put(nums[i], map.get(nums[i]) + 1);
			}
		}
		// 这里要排除多个0的情况
		if (map.containsKey(0)) {
			int zeroCount = map.get(0);
			// 有两个以上
			if (zeroCount >= 3) {
				result.add(createList(0, 0, 0));
			}
		}
		int target = 0;
		for (int i = 0; i < nums.length; i++) {
			target = -nums[i] / 2;
			// 如果nums[i]是2的倍数 同时-nums[i]/2存在且出现次数大于1，这里可以直接排除掉0的情况
			// 正数都放到前面
			if (nums[i] != 0 && nums[i] % 2 == 0 && map.containsKey(target) && map.get(target) > 1) {
				if (isHaveSame(result, nums[i], target, target) == false && nums[i] >= 0) {
					result.add(createList(nums[i], target, target));
				} else if (isHaveSame(result, target, target, nums[i]) == false && nums[i] < 0) {
					result.add(createList(target, target, nums[i]));
				}

			}
		}
//		print(result);
		// System.out.println("unique element nums:" + map.size());
		// 去重
		int count = 0;
		int newNums[] = new int[map.size()];
		Set<Integer> keys = map.keySet();
		Iterator<Integer> iter = keys.iterator();
		while (iter.hasNext()) {
			newNums[count] = iter.next();
			count++;
		}
		Arrays.sort(newNums);
		return newNums;
	}

	/**
	 * 寻找一个起点
	 * @param nums
	 * @return
	 */
	public int findStartIndex(int[] nums) {
		// 如果0不存在，那么就寻找第一个正数（一定存在）
		int result = findMaxFarIndex(nums, 0, 0, nums.length - 1);
		// System.out.println("result:" + result);
		// 这里可能会出现几个相同0的情况，找最左边的0作为起点
		if (nums[result] == 0) {
			for (int i = result; i >= 0; i--) {
				if (nums[i] != 0) {
					result = i + 1;
					break;
				}
			}
		}
		return result;
	}

	/**
	 * 找到最远的可能下标
	 * 
	 * @param sum
	 * @param nums
	 * @return
	 */
	public int findMaxFarIndex(int nums[], int target, int low, int high) {
		if (low > high) {
			if (low >= nums.length) {
				return low - 1;
			}
			return low;
		}
		int mid = (low + high) / 2;
		if (mid >= nums.length) {
			return mid - 1;
		}
		if (nums[mid] == target) {
			int index = mid;
			// 这里会遇到后面连续都是相同值的情况，这时要拿到最后的位置
			for (int i = low; i < nums.length - 1; i++) {
				if (nums[i] == nums[i + 1] && nums[i] == target) {
					index = i + 1;
				}
			}
			if (index >= nums.length) {
				return nums.length - 1;
			}
			return index;
		} else if (nums[mid] > target) {
			return findMaxFarIndex(nums, target, low, mid - 1);
		} else {
			return findMaxFarIndex(nums, target, mid + 1, high);
		}
	}

	public int binarySearch(int[] nums, int target, int low, int high) {
		if (low > high) {
			return -1;
		}
		int mid = (low + high) / 2;
		if (nums[mid] == target) {
			return mid;
		} else if (nums[mid] > target) {
			return binarySearch(nums, target, low, mid - 1);
		} else {
			return binarySearch(nums, target, mid + 1, high);
		}
	}

	/**
	 * 将三个数组合成一个List
	 * 
	 * @param i
	 * @param j
	 * @param k
	 * @return
	 */
	public List<Integer> createList(int i, int j, int k) {
		List<Integer> result = new ArrayList<Integer>(3);
		result.add(i);
		result.add(j);
		result.add(k);
		return result;
	}

	public boolean isHaveSame(List<List<Integer>> list, int one, int two, int three) {
		int size = list.size();
		if (size == 0) {
			return false;
		}
		for (int i = size - 1; i >= 0; i--) {
			if (list.get(i).get(0) == one && list.get(i).get(1) == two) {
				return true;
			}
		}
		return false;
	}

	public void print(List<List<Integer>> result) {
		// 这里打印前100个答案
		System.out.println("size:" + result.size());
		for (int i = 0; i < result.size() && i < 20; i++) {
			String str = "[";
			for (int j = 0; j < result.get(i).size(); j++) {
				if (j == result.get(i).size() - 1) {
					str += result.get(i).get(j);
				} else {
					str += (result.get(i).get(j) + ",");
				}
			}
			System.out.println(str + "]");
		}
	}

	public void printNums(int[] nums) {
		System.out.println("nums.length:" + nums.length);
		String str = "[";
		for (int i = 0; i < nums.length; i++) {
			if (i == nums.length - 1) {
				str += nums[i];
			} else {
				str += (nums[i] + ",");
			}
		}
		System.out.println(str + "]");
	}

	public static void main(String[] args) {
		ThreeSum7 s = new ThreeSum7();
		long time = System.currentTimeMillis();
		int nums[] = { -1, -2, -3, 4, 1, 3, 0, 3, -2, 1, -2, 2, -1, 1, -5, 4, -3 };
		// int nums[] = { -1, 0, 1, 0 };
		// int nums[] = { -1, 0, 0, 0, 0 };
		// int nums[] = { -1, -2, -3, 4, 1, 3, 0, 3, -2, 1, -2, 2, -1, 1, -5, 4,
		// -3 };
		// int nums[] = ThreeSumTestData.data;
		// System.out.println("nums length:" + nums.length);
		// s.threeSum(nums);
		s.print(s.threeSum(nums));
		// 1304
		System.out.println("runtime:" + (System.currentTimeMillis() - time));
		// for (int i = 0; i < nums.length; i++) {
		// System.out.println(nums[i]);
		// }
		// System.out.println(s.findMaxFarIndex(1, nums2, 0, nums.length - 1));
	}
}
