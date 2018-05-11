package easy;

import java.util.*;

public class Domain {

	public static List<String> subdomainVisits(String[] cpdomains) {
		Map<String, Integer> map = new HashMap<>();
		for (String cpdomain : cpdomains) {
			String[] split = cpdomain.split(" ");
			int count = Integer.valueOf(split[0]);
			String[] subD = split[1].split("\\.");
			String sub = subD[subD.length - 1];
			for (int i = subD.length - 2; i >= 0; i--) {
				int couS = map.getOrDefault(sub, 0);
				map.put(sub, couS + count);
				sub = subD[i] + "." + sub;
			}
			int couS = map.getOrDefault(sub, 0);
			map.put(sub, couS + count);
		}
		List<String> result = new ArrayList<>();
		for (String key : map.keySet()) {
			int val = map.get(key);
			StringBuilder sb = new StringBuilder();
			sb.append(val);
			sb.append(" ");
			sb.append(key);
			result.add(sb.toString());
		}
		return result;
	}

	public static void main(String[] args) {
		String[] arr = { "900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org" };
		System.out.println(subdomainVisits(arr));
	}

}
