package hard;

import java.util.*;

public class LongestValidParentheses {
	public static int longestValidParentheses(String s) {
		if (s.length() == 0)
			return 0;
		int result = 0;
		int res = 0;
		int left = 0;
		int right = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(')
				left++;
			else {
				if (left > 0) {
					left--;
					res += 2;
					result = Math.max(res, result);
				} else {
					left = 0;
					right = 0;
					res = 0;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(longestValidParentheses(")()())"));
	}
}
