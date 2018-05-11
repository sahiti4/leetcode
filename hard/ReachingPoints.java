package hard;

public class ReachingPoints {

	public static boolean reachingPoints(int sx, int sy, int tx, int ty) {
		while (tx >= sx && ty >= ty) {
			if (tx == sx && ty == sy)
				return true;
			if (tx == ty) {
				return false;
			}
			if (tx > ty) {
				int modul = Math.max(1, (tx - ty) / ty);
				if ((tx - sx) / ty > 0)
					modul = Math.min((tx - sx) / ty, modul);
				tx = tx - ty * modul;
			} else {
				int modul = Math.max(1, (ty - tx) / tx);
				if ((ty - sy) / tx > 0)
					modul = Math.min((ty - sy) / tx, modul);
				ty = ty - tx * modul;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(reachingPoints(9, 5, 12, 8));
	}

}
