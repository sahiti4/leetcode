package easy;

public class Sqrt {
	public static int mySqrt(int x) {
		int start = 0, end = x;
		if (x < 1)
			return 0;
		if(x>1 && x<4)
			return 1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (mid == (x / mid)) {
				return mid;
			} else if (mid > (x / mid)) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return end;
	}

	public static void main(String[] args) {
		System.out.println(mySqrt(2147395599));
	}
}
