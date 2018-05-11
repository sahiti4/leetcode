package easy;

public class Rotation {
	public static boolean rotateString(String A, String B) {
		int i = 0;
		if (A.length() != B.length())
			return false;
		while (i < A.length()) {
			if (B.startsWith(A.substring(i)))
				break;
			i++;
		}
		if (A.substring(0, i).equals(B.substring(A.length() - i )))
			return true;
		return false;
	}

	public static void main(String[] args) {
		System.out.println(rotateString("abcde", "eabcd"));
	}

}
