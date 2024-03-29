package 코드봄_level2;

import java.util.*;

/**
 * 캐시의 크기가 0이라면, 전부 5이다. 5 * 도시의 크기 리턴
 */
public class Level2_1차캐시 {
	public int solution(int cacheSize, String[] cities) {
		int answer = 0;
		List<String> cache = new ArrayList<>();

		if (cacheSize == 0) {
			return cities.length * 5;
		}

		for (String str : cities) {
			String city = str.toUpperCase();

			if (cache.contains(city)) {
				cache.remove(city);
				cache.add(city);
				answer++;

			} else {
				if (cache.size() == cacheSize) {
					cache.remove(0);
				}

				cache.add(city);
				answer += 5;
			}
		}

		return answer;
	}
}
