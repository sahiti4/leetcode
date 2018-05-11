package easy;

import java.util.*;

public class PascalsTriangle {
	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> results = new ArrayList<>();
		if (numRows <= 0)
			return results;
		int n = 0;
		List<Integer> temp = new ArrayList<>();
		temp.add(1);
		results.add(temp);
		n++;
		if (numRows == 1) {
			return results;
		}
		while (n < numRows) {
			results.add(gen(results.get(results.size() - 1)));
			n++;
		}

		return results;
	}

	public static List<Integer> gen(List<Integer> last) {
		List<Integer> result = new ArrayList<>();
		result.add(1);
		for (int i = 1; i < last.size(); i++) {
			result.add(last.get(i - 1) + last.get(i));
		}
		result.add(1);
		return result;
	}

	public static void main(String[] args) {
		System.out.println(generate(4));
	}

}
