package medium;

import java.util.*;

public class MergeIntervak {
	public List<Interval> merge(List<Interval> intervals) {
		List<Interval> result = new ArrayList<>();
		Comparator<Interval> byRanking = (Interval inte1, Interval inte2) -> inte1.start - inte2.start;
		Collections.sort(intervals, byRanking);
		int start = intervals.get(0).start;
		int end = intervals.get(0).end;
		for (int i = 1; i < intervals.size(); i++) {
			Interval curr = intervals.get(i);
			if (end < curr.start) {
				end = Math.max(end, curr.end);
			} else {
				result.add(new Interval(start, end));
				start = curr.start;
			}
		}
		return result;
	}
}

class Interval implements Comparable<Interval> {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}

	@Override
	public int compareTo(Interval o) {
		return this.start - o.start;
	}
}
