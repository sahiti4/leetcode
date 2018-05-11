package easy;

public class TitleNumber {

	public static int titleToNumber(String s) {
		int i = 0;
		int result = 0;
		while (i < s.length()) {
			char curr = s.charAt(i);
			int temp = curr;
			temp = temp - 64;
			result = result * 26 + temp;
			i++;
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(titleToNumber("AB"));
	}

}
