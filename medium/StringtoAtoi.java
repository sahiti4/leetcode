package medium;

public class StringtoAtoi {

	public static int myAtoi(String str) {
		int result = 0;
		int sign = 0;
		int j = 0;
		if (str.length() == 0)
			return result;
		while (Character.isWhitespace(str.charAt(j))) {
			j++;
		}
		if (j < str.length()) {
			if (str.charAt(j) == '-') {
				sign = -1;
				j++;
			} else {
				sign = +1;
				if (str.charAt(j) >= 48 && str.charAt(j) <= 57) {
					result += (int) (str.charAt(j) - 48);
					j++;
				} else if (str.charAt(j) == '+') {
					j++;
				} else if (str.charAt(j) != '+') {
					return 0;
				}
			}
		}
		for (int i = Math.max(j, 1); i < str.length(); i++) {
			boolean whiteSpace = str.charAt(i) >= 48 && str.charAt(i) <= 57 ? false : true;
			if (whiteSpace)
				return sign * result;
			if (result < 214748364 || ((int) (str.charAt(i) - 48) <= 7 && result == 214748364)) {
				result = (result * 10) + (int) (str.charAt(i) - 48);
			} else {
				if (sign > 0) {
					return Integer.MAX_VALUE;
				} else {
					return Integer.MIN_VALUE;
				}
			}
		}
		return sign * result;

	}

	public static void main(String[] args) {
		System.out.println(myAtoi("   321"));
	}

}
