package medium;

public class ReverseWords {
	public void reverseWords(char[] str) {
		String s = str.toString();
		String[] strArr = s.split(" ");
		String result = "";
		for (int i = strArr.length - 1; i >= 0; i--) {
			result = strArr[i] + result;
		}
	}
}
