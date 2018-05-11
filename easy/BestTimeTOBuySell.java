package easy;

public class BestTimeTOBuySell {

	public static int maxProfit(int[] prices) {
		int profit = 0;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < prices.length; i++) {
			if (prices[i] < min)
				min = prices[i];
			else if (prices[i] - min > profit)
				profit = prices[i] - min;
		}
		return profit;
	}

	public static void main(String[] args) {
		int[] prices = { 1, 2 };
		System.out.println(maxProfit(prices));
	}
}
