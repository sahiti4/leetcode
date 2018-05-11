package easy;

import java.util.*;

public class Test {
	public static String similarRGB(String color) {
		Map<Integer, String> map2 = new HashMap<>();
		map2.put(10, "a");
		map2.put(11, "b");
		map2.put(12, "c");
		map2.put(13, "d");
		map2.put(14, "e");
		map2.put(15, "f");
		int min = Integer.MIN_VALUE;
		String one = color.substring(1, 3);
		String two = color.substring(3, 5);
		String three = color.substring(5, 7);
		int first = 0, second = 0, third = 0;
		first = Integer.parseInt(one, 16);
		second = Integer.parseInt(two, 16);
		third = Integer.parseInt(three, 16);
		int r = 0, g = 0, b = 0;
		for (int i = 0; i < 16; i++) {
			for (int j = 0; j < 16; j++) {
				for (int k = 0; k < 16; k++) {
					int temp = (first - (17 * i)) * (first - (17 * i));
					temp += (second - (17 * j)) * (second - (17 * j));
					temp += (third - (17 * k)) * (third - (17 * k));
					temp = (-1) * temp;
					if (temp > min) {
						min = temp;
						System.out.println(temp);
						r = i;
						g = j;
						b = k;
					}
				}
			}
		}
		String result = "#";
		result = result + ((r > 9) ? map2.get(r) : Integer.toString(r)) + ((r > 9) ? map2.get(r) : Integer.toString(r));
		result = result + ((g > 9) ? map2.get(g) : Integer.toString(g)) + ((g > 9) ? map2.get(g) : Integer.toString(g));
		result = result + ((b > 9) ? map2.get(b) : Integer.toString(b)) + ((b > 9) ? map2.get(b) : Integer.toString(b));
		return result;
	}

	public static void main(String[] args) {
		System.out.println(similarRGB("#09f166"));
	}
}
