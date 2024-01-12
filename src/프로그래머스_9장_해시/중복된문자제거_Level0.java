package 프로그래머스_9장_해시;

import java.util.*;
/**
 Set을 통해 중복 검사를 하고, Set에 넣어준다.
 통과한 char형을 StringBuilder에 넣는다.
 **/

public class 중복된문자제거_Level0 {
    public String solution(String my_string) {
        Set<Character> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        for(char c : my_string.toCharArray()) {
            if(set.contains(c)) continue;

            set.add(c);
            sb.append(c);
        }

        return sb.toString();
    }
}
