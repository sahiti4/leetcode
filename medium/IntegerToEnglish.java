package medium;

public class IntegerToEnglish {

	public static String numberToWords(int num) {
		if (num == 0)
			return "Zero";
		int n = num;
		String result = "";
		int count = -1;
		String[] first = { "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven",
				"Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seveteen", "Eighteen", "Nineteen" };
		String[] ten = { "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };
		String[] thou = { "Thousand", "Million", "Billion" };
		while (n > 0) {
			String test = "";
			int ones = n % 10;
			n = n / 10;
			int tens = n % 10;
			n = n / 10;
			if (tens <= 1) {
				int temp = tens * 10 + ones;
				if (temp > 0)
					test = first[temp - 1] + " " + test;
			} else {
				if (ones > 0)
					test = first[ones - 1] + " " + test;
				test = ten[tens - 1] + " " + test;
			}
			int hundreds = n % 10;
			n = n / 10;
			if (hundreds > 0) {
				test = first[hundreds - 1] + " " + "Hundred " + test;
			}
			count += 3;
			if (!test.equals("")) {
				if (count / 3 > 0)
					result = test + thou[(count / 3) - 1] + " " + result;
				else
					result = test + result;
			}
		}
		return result.trim();
	}

	public static void main(String[] args) {
		System.out.println(numberToWords(12345678));

	}

}
