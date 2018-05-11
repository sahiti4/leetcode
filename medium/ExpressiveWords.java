package medium;

public class ExpressiveWords {

	public int expressiveWords(String S, String[] words) {
		int result = 0;
		String s = "";
		char prev = S.charAt(0);
		int count = 0;
		for (int i = 1; i < S.length(); i++) {
			char c = S.charAt(i);
			if (c != prev) {
				if (count >= 3)
					s = "~" + prev + s;
				if (count == 2)
					s = prev + prev + s;
				count = 1;
				prev = c;
			} else
				count++;
		}
		if (count >= 3)
			s = "~" + prev + s;
		else if (count >= 1) {
			while (count > 0) {
				s = prev + s;
				count--;
			}
		}

		for (String word : words) {
			if (check(s, word))
				result++;
		}
		return result;
	}

	public boolean check(String word1, String word2) {

		return true;
	}

}
