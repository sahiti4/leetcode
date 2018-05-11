package medium;

public class LongestPalidromicSubstring {

	public static String longestPalindrome(String s) {
		int n = s.length();
		String result = "";
		for (int i = 1; i < n - 1; i++) {
			String temp = isPalindrome(s, i - 1, i + 1);
			result = temp.length() > result.length() ? temp : result;
		}
		for (int i = 0; i < n - 1; i++) {
			String temp = isPalindrome(s, i, i + 1);
			result = temp.length() > result.length() ? temp : result;
		}
		return result;
	}

	public static String isPalindrome(String s, int left, int right) {
		if (s.charAt(left) != s.charAt(right)) {
			String temp = "" + s.charAt(left);
			return temp;
		}
		while (left >= 0 && right < s.length() && (s.charAt(left) == s.charAt(right))) {
			left--;
			right++;
		}
		left++;
		return s.substring(left, right);
	}

	public static void main(String[] args) {
		System.out.println(longestPalindrome("abbd"));
	}
}
