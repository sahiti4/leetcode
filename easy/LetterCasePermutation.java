package easy;

import java.util.*;

public class LetterCasePermutation {

	public static List<String> letterCasePermutation(String S) {
		return letterCasePermutation(S, 0);
	}

	public static List<String> letterCasePermutation(String s, int i) {
		List<String> results = new ArrayList<String>();
		if (i == s.length()) {
			results.add("");
			return results;
		}
		int c = s.charAt(i);
		List<String> subResults = letterCasePermutation(s, i + 1);
		if (c > 47 && c < 58) {
			for (String m : subResults) {
				results.add((char) c + m);
			}
		} else {
			for (String m : subResults) {
				char lch = c > 96 && c < 123 ? (char) c : (char) (c + 32);
				char hch = c > 96 && c < 123 ? (char) (c - 32) : (char) c;
				results.add(lch + m);
				results.add(hch + m);
			}
		}
		return results;
	}

	public static void main(String[] args) {

		System.out.println(letterCasePermutation("a1b2"));
	}
}
