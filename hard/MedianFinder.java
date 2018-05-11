package hard;

import java.util.*;

class MedianFinder {

	List<Integer> list = null;

	public MedianFinder() {
		list = new ArrayList<>();
	}

	public void addNum(int num) {
		if (list.size() == 0)
			list.add(num);
		else {
			int index = search(list, num, 0, list.size() - 1);
			list.add(index + 1, num);
		}
	}

	public double findMedian() {
		if (list.size() % 2 != 0)
			return (list.get(list.size() / 2));
		return (list.get((list.size() / 2) - 1) + list.get(list.size() / 2)) / 2.00;
	}

	public int search(List<Integer> list, int target, int l, int r) {
		if (l == r) {
			if (list.get(l) > target)
				return l - 1;
			return l;
		}
		int midIndex = l + (r - l) / 2;
		int mid = list.get(l + (r - l) / 2);
		if (mid == target)
			return midIndex;
		else if (mid > target)
			return search(list, target, l, midIndex);
		else
			return search(list, target, midIndex + 1, r);
	}

	public static void main(String[] args) {
		MedianFinder obj = new MedianFinder();
		obj.addNum(2);
		obj.addNum(1);
		obj.addNum(3);
		obj.addNum(-1);
		System.out.println(obj.findMedian());
	}
}
