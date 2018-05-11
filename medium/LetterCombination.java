package medium;

import java.util.*;

public class LetterCombination {
	public static List<String> letterCombinations(String digits) {
		String[] characters = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		List<String> result = letterCombinations(digits, characters, 0);
		return result;
	}

	public static List<String> letterCombinations(String digits, String[] characters, int i) {
		List<String> result = new ArrayList<>();
		if (i == digits.length()) {
			result.add("");
			return result;
		}
		List<String> subResult = letterCombinations(digits, characters, i + 1);
		int currDigit = Character.getNumericValue(digits.charAt(i));
		for (char c : characters[currDigit].toCharArray()) {
			for (String s : subResult) {
				result.add(c + s);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(letterCombinations("23"));

	}

}
