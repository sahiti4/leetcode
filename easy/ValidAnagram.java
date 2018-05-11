package easy;

import java.util.Arrays;

public class ValidAnagram {

	public boolean isAnagram(String s, String t) {
		char[] sc = s.toCharArray();
		Arrays.sort(sc);
		char[] tc = t.toCharArray();
		Arrays.sort(tc);
		if (sc.length != tc.length)
			return false;
		for (int i = 0; i < sc.length; i++) {
			if (sc[i] != tc[i])
				return false;
		}
		return true;
	}

}
