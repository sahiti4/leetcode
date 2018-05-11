package easy;

public class FactorialTrialingZeroes {

	public static int trailingZeroes(int n) {
		if (n < 5)
			return 0;
		int result = 0;
		while (n > 0) {
			result += (n / 5);
			n /= 5;
		}
		return result;
	}

	public static void main(String[] args) {

	}

}
