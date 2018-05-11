package medium;

public class DivideIntegers {

	public static int divide(int dividend, int divisor) {
		int res = 0;
		int sign = 1;
		if (dividend < 0) {
			sign = sign * -1;
			dividend = -1 * dividend;
		}
		if (divisor < 0) {
			sign = sign * -1;
			divisor = -1 * divisor;
		}
		int divi = divisor;
		int mul = 1;
		while (dividend - (2 * divi) >= 0) {
			divi = (2 * divi);
			mul = 2 * mul;
		}
		return res * sign;

	}

	public static void main(String[] args) {

	}

}
