package easy;

public class ReverseString {

	public static String reverseString(String s) {
		String first = "";
		String second = "";
		int i = s.length() - 1;
		int j = 0;
		while (i > j) {
			second = second + s.charAt(i);
			first = s.charAt(j) + first;
			i--;
			j++;
		}
		String result = i==j ? second + s.charAt(i) + first : second + first;
		return result;

	}

	public static void main(String[] args) {
		System.out.println(reverseString("hello"));
	}

}
