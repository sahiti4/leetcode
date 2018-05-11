package easy;

public class CountSay {

	public static String countAndSay(int n) {
		if (n == 1)
			return "1";
		String current = "1";
		String res = "";
		while (n > 1) {
			int curr = Character.getNumericValue(current.charAt(0));
			int count = 1;
			res = "";
			for (int i = 1; i < current.length(); i++) {
				int currChar = Character.getNumericValue(current.charAt(i));
				if (curr == currChar) {
					count++;
				} else {
					res = res + count + curr;
					curr = currChar;
					count = 1;
				}
			}
			res = res + count + curr;
			current = res;
			n--;
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(countAndSay(6));
	}

}
