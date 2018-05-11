package medium;

public class ValiParenthesesString {

	public boolean checkValidString(String s) {
		int countMax = 0;
		int countMin = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ')') {
				countMin--;
				countMax--;
				if (countMax < 0)
					return false;
			} else if (s.charAt(i) == '(') {
				countMin++;
				countMax++;
			} else {
				countMax++;
			}
		}
		if (countMin > 0) {
			if (countMax - countMin < 0)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {

	}
}
