package easy;

public class StrStr {

	public static int strStr(String haystack, String needle) {
		if (needle.length() == 0)
			return 0;
		for (int i = 0; i < haystack.length(); i++) {
			if (needle.charAt(0) == haystack.charAt(i)) {
				boolean flag = true;
				if (i + needle.length() > haystack.length()) {
					flag = false;
				} else if (i + needle.length() <= haystack.length()) {
					for (int j = i; j < i + needle.length(); j++) {
						if (haystack.charAt(j) != needle.charAt(j - i)) {
							flag = false;
							break;
						}
					}
				}
				if (flag)
					return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		System.out.println(strStr("hello", "ll"));
	}

}
