package easy;

public class PlusOne {
	public int[] plusOne(int[] digits) {
		int[] result = new int[digits.length + 1];
		int carry = 0;
		int temp = digits[digits.length - 1] + 1;
		carry = temp / 10;
		digits[digits.length - 1] = temp % 10;
		for (int i = digits.length - 2; i >= 0; i--) {
			int temp1 = digits[i] + carry;
			carry = temp1 / 10;
			digits[i] = temp1 % 10;
		}
		if (carry == 0)
			return digits;
		else {
			result[0] = 1;
			for (int i = 1; i <= digits.length; i++) {
				result[i] = digits[i - 1];
			}
			return result;
		}
	}

	public static void main(String[] args) {

	}
}
