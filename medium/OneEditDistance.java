package medium;

public class OneEditDistance {
	public static boolean isOneEditDistance(String s, String t) {
		if (Math.abs(s.length() - t.length()) > 1)
			return false;
		int count = 0;
		if (s.length() == t.length()) {
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) != t.charAt(i))
					count++;
				if (count > 1)
					return false;
			}
		} else {
			String s1 = s.length() >= t.length() ? s : t;
			String t1 = s.length() >= t.length() ? t : s;
			if (t1.length() == 0)
				return true;
			int i = 0;
			for (int j = 0; j < t1.length();) {
				if (s1.charAt(i) != t1.charAt(j)) {
					count++;
					if (i + 1 < s1.length() && s1.charAt(i + 1) == t1.charAt(j))
						i++;
					else {
						i++;
						j++;
					}
				} else {
					i++;
					j++;
				}
				if (count > 1)
					return false;
			}
			if (i < s1.length())
				count++;
		}
		return count == 1;
	}

	public static void main(String[] args) {
		System.out.println(isOneEditDistance("ab", "a"));
	}
}
