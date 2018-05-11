package easy;

import java.util.*;

public class ValidParentheses {

	public static boolean isValid(String s) {
		Set<Character> left = new HashSet<>();
		Set<Character> right = new HashSet<>();
		left.add('[');
		left.add('(');
		left.add('{');
		right.add(']');
		right.add(')');
		right.add('}');
		Stack<Character> st = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char currentChar = s.charAt(i);
			if (left.contains(currentChar)) {
				st.add(currentChar);
			} else if (right.contains(currentChar)) {
				if (st.isEmpty())
					return false;
				char poped = st.pop();
				if (currentChar == '}') {
					if (poped != '{')
						return false;
				} else if (currentChar == ')') {
					if (poped != '(')
						return false;
				} else {
					if (poped != '[')
						return false;
				}
			}
		}
		if (!st.isEmpty()) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {

	}

}
