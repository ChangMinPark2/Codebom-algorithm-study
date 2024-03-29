package 코드봄_level2;

import java.util.ArrayList;
import java.util.List;

public class Level2_배열자르기 {
	public int[] solution(int n, long left, long right) {
		List<Long> list = new ArrayList<>();

		for (long i = left; i <= right; i++) {
			list.add(Math.max((i / n) + 1, (i % n) + 1));
		}

		return list.stream()
			.mapToInt(Long::intValue)
			.toArray();
	}
}
