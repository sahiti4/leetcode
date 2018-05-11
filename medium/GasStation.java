package medium;

public class GasStation {

	public static int canCompleteCircuit(int[] gas, int[] cost) {
		int curr = 0;
		int start = 0;
		int total = 0;
		for (int i = 0; i < gas.length; i++) {
			curr = curr + gas[i] - cost[i];
			if (curr < 0) {
				while (start <= i && curr < 0) {
					curr = curr - (gas[start] - cost[start]);
					total = total + gas[start] - cost[start];
					start++;
				}
			}
		}
		return curr + total >= 0 ? start : -1;
	}

	public static void main(String[] args) {
		int[] gas = { 4 };
		int[] cost = { 5 };
		System.out.println(canCompleteCircuit(gas, cost));
	}

}
