package easy;

import java.util.*;

public class RomanToInteger {
	public static int romanToInt(String s) {
		int latest = 0;
		int result = 0;
		Map<Character, Integer> map = new HashMap<>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		for (int i = s.length() - 1; i >= 0; i--) {
			int temp = map.get(s.charAt(i));
			if (temp >= latest)
				result += temp;
			else {
				result -= temp;
				latest = temp;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		romanToInt("CDXM");
	}
}
