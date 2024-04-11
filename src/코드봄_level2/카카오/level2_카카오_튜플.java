package 코드봄_level2.카카오;

import java.util.*;

public class level2_카카오_튜플 {
	public int[] solution(String s) {
		s = s.replace("{{", "");
		s = s.replace("}}", "");
		s = s.replace("},{", " ");
		String[] str = s.split(" ");
		Arrays.sort(str, (o1, o2) -> o1.length() - o2.length());
		List<Integer> list = new ArrayList<>();

		for(String a: str) {
			if(a.length() == 1) {
				list.add(Integer.parseInt(a));
			} else {
				String[] temp = a.split(",");
				for(String z : temp) {
					if (!list.contains(Integer.parseInt(z))) {
						list.add(Integer.parseInt(z));
					}
				}
			}
		}
		return list.stream().mapToInt(Integer::intValue).toArray();
	}

	public static void main(String[] args) {
		for (int i = 0; i < 20; i++) {
			System.out.println(UUID.randomUUID());
		}
 	}
}
