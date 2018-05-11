package easy;

public class CountPrimes {

	public static int countPrimes(int n) {
		if (n <= 1)
			return 0;
		if (n <= 3)
			return n - 2;
		boolean[] primeFlag = new boolean[n];
		for (int i = 2; i < n; i++) {
			for (int j = 2; i * j < n; j++) {
				primeFlag[i * j] = true;
			}
		}
		int count = -2;
		for (boolean flag : primeFlag) {
			if (!flag)
				count++;
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(countPrimes(10));
	}
}
