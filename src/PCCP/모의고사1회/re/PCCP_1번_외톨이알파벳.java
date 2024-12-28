package PCCP.모의고사1회.re;

/**
 n -> 2600 (2차원 dp, 탐색 등)
 **/
import java.util.*;

public class PCCP_1번_외톨이알파벳 {
    public String solution(String input_string) {
        Set<Character> answer = new HashSet<>();
        Set<Character> test = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        char[] ch = input_string.toCharArray();

        test.add(ch[0]);

        for (int i = 1; i < ch.length; i++) {
            if (ch[i] == ch[i - 1]) {
                continue; //같다면 패스
            }

            if(test.contains(ch[i])) {
                answer.add(ch[i]);
            } else {
                test.add(ch[i]);
            }
        }

        List<Character> list = new ArrayList<>(answer);
        Collections.sort(list);

        for(char c : list) {
            sb.append(c);
        }

        return sb.length() == 0 ? "N" : sb.toString();
    }
}
