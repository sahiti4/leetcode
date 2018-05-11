package medium;

import java.util.*;

public class BasicCal {

	public static int calculate(String s) {
		Stack<Integer> stack = new Stack<>();
		int res = 0;
		for (int i = 0; i < s.length(); i++) {
			boolean flag = false;
			char c = s.charAt(i);
			if (c == '/' || c == '*' || c == '+' || c == '-') {
				int m = stack.pop();
				int n = 0;
				i++;
				while (i < s.length() && Character.isDigit(s.charAt(i))) {
					if (flag)
						n = 10 * n + Character.getNumericValue(s.charAt(i));
					else {
						n = n + Character.getNumericValue(s.charAt(i));
						flag = true;
					}
					i++;
				}
				if (i != s.length()) {
					i--;
				}
				if (c == '/') {
					m = m / n;
				} else if (c == '*') {
					m = m * n;
				} else if (c == '+') {
					m = m + n;
				} else {
					m = m - n;
				}
				stack.push(m);
			}
			int x = 0;
			flag = false;
			while (i < s.length() && Character.isDigit(s.charAt(i))) {
				if (flag)
					x = 10 * x + Character.getNumericValue(s.charAt(i));
				else {
					x = x + Character.getNumericValue(s.charAt(i));
					flag = true;
				}
				i++;
			}
			if (i != s.length()) {
				i--;
			}
			stack.push(x);
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(calculate("1*2-3/4+5*6-7*8+9/10"));
	}

}
