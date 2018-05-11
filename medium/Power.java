package medium;

public class Power {

	public static double myPow(double x, int n) {
		if (x == 1.00 || x == 0.00)
			return x;
		if (n < 0) {
			n = -1 * n;
			if (n > 0)
				x = 1 / x;
		}
		if (n == 0)
			return 1.00;
		if (n % 2 == 0)
			return myPow(x * x, n / 2);
		else {
			return x * myPow(x * x, n / 2);
		}
	}

	public static void main(String[] args) {
		System.out.println(myPow(2.00000, -2147483648));
	}

}
