package easy;

public class HammingDistance {
	public static int hammingDistance(int x, int y) {
		String x2 = Integer.toBinaryString(x);
		String y2 = Integer.toBinaryString(y);
		String x1 = x2.length() >= y2.length() ? x2 : y2;
		String y1 = x2.length() < y2.length() ? x2 : y2;
		int res = 0;
		for (int i = x1.length() - 1, j = y1.length() - 1; i >= 0 || j >= 0; i--, j--) {
			int a = Character.getNumericValue(x1.charAt(i));
			int b = 0;
			if (j >= 0)
				b = Character.getNumericValue(y1.charAt(j));
			if (a != b)
				res++;
		}
		return res;
	}

	public static void main(String[] args) {
		hammingDistance(1, 4);
	}

}
