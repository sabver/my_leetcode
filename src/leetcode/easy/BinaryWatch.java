package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

import leetcode.util.Util;

public class BinaryWatch {
	List<Integer> minutes = new ArrayList<>();
	List<Integer> hours = new ArrayList<>();
	// 0~3 hour
	// 4~9 minute
	int[] map = { 8, 4, 2, 1, 32, 16, 8, 4, 2, 1 };

	public List<String> readBinaryWatch(int turnedOn) {
		backtrack(0, 0, 0, 0, turnedOn);
		List<String> result = new ArrayList<>();
		for (int i = 0; i < minutes.size(); i++) {
			result.add(getHourMinute(minutes.get(i), hours.get(i)));
		}
		return result;
	}

	public String getHourMinute(int m, int h) {
		String hourStr = "" + h;
		String mStr = m >= 10 ? "" + m : "0" + m;
		return hourStr + ":" + mStr;
	}

	public void backtrack(int start, int sumMinute, int sumHour, int count, int k) {
		if (count == k) {
			if (sumHour <= 11 && sumMinute <= 59) {
				minutes.add(sumMinute);
				hours.add(sumHour);
			}
			return;
		}
		for (int i = start; i < map.length; i++) {
			if (i < 4) {				
				sumHour += map[i];
			} else {
				sumMinute += map[i];
			}
			count++;
			backtrack(i + 1, sumMinute, sumHour, count, k);
			if (i < 4) {
				sumHour -= map[i];
			} else {
				sumMinute -= map[i];
			}
			count--;
		}
	}

	public static void main(String[] args) {
		BinaryWatch b = new BinaryWatch();
		int turnedOn = 9;
		Util.p(b.readBinaryWatch(turnedOn));
	}

}
