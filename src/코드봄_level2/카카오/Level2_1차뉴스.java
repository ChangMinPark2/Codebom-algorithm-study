package 코드봄_level2.카카오;

import java.util.*;

public class Level2_1차뉴스 {
	public int solution(String str1, String str2) {
		str1 = str1.toUpperCase();
		str2 = str2.toUpperCase();

		List<String> list1 = new ArrayList<>();
		List<String> list2 = new ArrayList<>();
		List<String> set = new ArrayList<>();
		List<String> sumSet = new ArrayList<>();

		for (int i = 0; i < str1.length() - 1; i++) {
			char a = str1.charAt(i);
			char b = str1.charAt(i + 1);

			if (Character.isLetter(a) && Character.isLetter(b)) {
				list1.add(String.valueOf(a) + String.valueOf(b));
			}
		}

		for (int i = 0; i < str2.length() - 1; i++) {
			char a = str2.charAt(i);
			char b = str2.charAt(i + 1);

			if (Character.isLetter(a) && Character.isLetter(b)) {
				list2.add(String.valueOf(a) + String.valueOf(b));
			}
		}

		Collections.sort(list1);
		Collections.sort(list2);

		for(String s : list1) {
			if(list2.remove(s)) {
				sumSet.add(s);
			}
			set.add(s);
		}

		for(String s : list2) { // 교집합에서 제외된 것 뺀 나머지 합집합에 추가
			set.add(s);
		}

		if(set.isEmpty()) return 65536;

		double answer = (double) sumSet.size() / (double) set.size();

		return (int) (answer * 65536);
	}
}
