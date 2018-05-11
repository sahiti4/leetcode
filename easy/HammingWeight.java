package easy;

public class HammingWeight {

	public int hammingWeight(int n) {
		String s = Integer.toBinaryString(n);
		int count = 0;
		for (char c : s.toCharArray()) {
			if (Character.getNumericValue(c) == 1)
				count++;
		}
		return count;
	}

	public static void main(String[] args) {
	}

}
