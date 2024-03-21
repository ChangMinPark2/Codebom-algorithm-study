package 코드봄_level2;

import java.util.*;
public class Level2_귤고르기 {
	public int solution(int k, int[] tangerine) {
		Map<Integer, Integer> map = new HashMap<>();

		int count = 0;

		for(int i : tangerine) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}

		List<Integer> list = new ArrayList<>(map.values());

		Collections.sort(list, (o1, o2) -> o2 - o1);

		//22, 33, 55 2, 2, 2
		//1111,222,3 -> 4, 3, 1

		for(int i : list) {
			k -= i;
			count++;

			if(k <= 0) break;
		}

		return count;
	}
}
