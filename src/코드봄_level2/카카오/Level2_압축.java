package 코드봄_level2.카카오;

import java.util.*;

public class Level2_압축 {
	public int[] solution(String msg) {
		List<String> list = new ArrayList<>();
		List<Integer> result = new ArrayList<>();

		for (int i = 0; i < 26; i++) {
			list.add(String.valueOf((char)('A' + i)));
		}

		for (int i = 0; i < msg.length(); i++) {
			for (int j = list.size() - 1; j >= 0; j--) {
				if (msg.substring(i).startsWith(list.get(j))) {
					i += list.get(j).length() - 1;
					result.add(j + 1);

					if (i + 1 < msg.length()) {
						list.add(list.get(j) + msg.charAt(i + 1));
					}
					break;
				}
			}
		}

		return result
			.stream()
			.mapToInt(Integer::intValue)
			.toArray();
	}
}
