package PCCP;
/**
 소문자 -> 2회 이상 나타난 알파벳이 2개 이상의 부분 나뉨 <외톨이 알파벳> (붙어 있으면 안 된다)
 **/
import java.util.*;

public class PCCP_1_1번_외톨이알파벳 {
	public String solution(String input_string) {
		Set<String> set = new TreeSet<>();
		StringBuilder sb = new StringBuilder();

		for(int i = 0; i < input_string.length(); i++) {
			char c = input_string.charAt(i);

			for(int j = i + 1; j < input_string.length(); j++) {
				if(c != input_string.charAt(j)) {
					String temp = input_string.substring(j);

					if(temp.contains(String.valueOf(c))){
						set.add(String.valueOf(c));
					}
				}
			}
		}

		if(set.isEmpty()) return "N";

		String[] answer = set.toArray(new String[0]);
		for (String str : answer) {
			sb.append(str);
		}

		return sb.toString();
	}
}
