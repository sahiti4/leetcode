package easy;

public class ConvertTitle {

	public static String convertToTitle(int n) {
		String result = "";
		while (n > 0) {
			int temp = n % 26;
			if (temp == 0) {
				result = (char) (26 + 64) + result;
				n = n / 26 - 1;
			}
			if (temp > 0) {
				result = (char) (temp + 64) + result;
				n = n / 26;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(convertToTitle(52));
	}

}
