package easy;

public class RotateDigits {

	public static int rotatedDigits(int N) {
		int count = 0;
		int i = 0;
		while (i <= N) {
			int j = i;
			while (j > 0) {
				int mod = j % 10;
				j = j / 10;
				if (mod == 2 || mod == 5 || mod == 6 || mod == 9) {
					count++;
					break;
				}
			}
			i++;
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(rotatedDigits(854));
	}

}
