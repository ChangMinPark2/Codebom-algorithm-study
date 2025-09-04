package programmers;

import java.util.*;

public class lv1_완주하지못한선수 {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();

        for(String s : participant) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        for(String s : completion) {
            map.put(s, map.getOrDefault(s, 0) - 1);
        }

        for(String key : map.keySet()) {
            if(map.get(key) == 1) {
                return key;
            }
        }

        return "";
    }
}
