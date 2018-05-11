package medium;

public class ValidParenthesesString {
	public boolean checkValidString(String s) {
		return checkValidString(s, 0, 0);
	}

	public boolean checkValidString(String s, int index, int count) {
		if (index >= s.length())
			return count == 0;
		if (count < 0)
			return false;
		boolean flag1 = false, flag2 = false, flag3 = false;
		if (s.charAt(index) == '(') {
			count++;
			flag1 = checkValidString(s, index + 1, count);
		} else if (s.charAt(index) == ')') {
			count--;
			flag2 = checkValidString(s, index + 1, count);
		} else {
			flag3 = checkValidString(s, index + 1, count + 1) || checkValidString(s, index + 1, count - 1)
					|| checkValidString(s, index + 1, count);
		}
		return flag1 || flag2 || flag3;
	}

	public static boolean checkValidString2(String s) {
		int min = 0;
		int max = 0;
		for (int i = 0; i < s.length(); i++) {
			char curr = s.charAt(i);
			if (curr == '(') {
				min++;
				max++;
			} else if (curr == ')') {
				if (min > 0) {
					min--;
				}
				max--;
				if (max < 0)
					return false;
			} else {
				if (min > 0) {
					min--;
				}
				max++;
			}

		}
		return min == 0;
	}

	public static void main(String[] args) {
		System.out.println(checkValidString2("(((((()*)(*)*))())())(()())())))((**)))))(()())()"));
	}
}
