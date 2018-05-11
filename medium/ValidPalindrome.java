package medium;

public class ValidPalindrome {

	public static boolean isPalindrome(String s) {
		s = s.toLowerCase();
		s = s.replaceAll("[^a-z0-9]+", "");
		if (s.length() == 0)
			return true;
		int len = s.length();
		String firstHalf = s.substring(0, len / 2);
		for (int i = 0; i < len / 2; i++) {
			if (firstHalf.charAt(i) != s.charAt(len-1-i))
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(isPalindrome("aa"));
	}
}
