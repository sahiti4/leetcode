package medium;

public class RollingString {

	public static String roll(int[] a, String s) {
		int[] rollCounts = new int[s.length()];
		for (int i = 0; i < a.length; i++) {
			rollCounts[a[i] - 1]++;
		}
		for (int i = s.length() - 2; i >= 0; i--) {
			rollCounts[i] += rollCounts[i + 1];
		}
		String result = "";
		for (int i = 0; i < s.length(); i++) {
			char c = (char) ((s.charAt(i) + rollCounts[i]) > 122 ? (s.charAt(i) + rollCounts[i]) - 26
					: (s.charAt(i) + rollCounts[i]));
			result = result + c;
		}
		return result;
	}

	public static void main(String[] args) {
		int[] roll = { 1, 1, 3, 4 };
		System.out.println(roll(roll, "zcza"));
	}

}
