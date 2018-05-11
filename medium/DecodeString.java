package medium;

public class DecodeString {

	public static String decodeString(String s) {
		return decodeString(s, 0, s.length());
	}

	public static String decodeString(String s, int i, int j) {
		String result = "";
		for (int m = i; m < j; m++) {
			if (Character.isDigit(s.charAt(m))) {
				int num = Character.getNumericValue(s.charAt(m));
				while (Character.isDigit(s.charAt(m + 1))) {
					num = num * 10 + Character.getNumericValue(s.charAt(m + 1));
					m++;
				}
				int start = m + 1;
				int count = 1;
				m = m + 2;
				while (count > 0) {
					if (s.charAt(m) == '[') {
						count++;
					} else if (s.charAt(m) == ']') {
						count--;
					}
					m++;
				}
				String sub = decodeString(s, start + 1, --m);
				for (int c = num; c > 0; c--) {
					result = result + sub;
				}
			} else {
				result = result + s.charAt(m);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(decodeString("10[leetcode]"));
	}

}
