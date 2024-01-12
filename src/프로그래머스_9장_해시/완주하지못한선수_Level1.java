package 프로그래머스_9장_해시;
/**
 * <문제풀이흐름>
 * before + 1
 * after - 1
 * 0이 아닌 것을 리턴한다.
 **/

import java.util.*;
import java.util.stream.Collectors;

public class 완주하지못한선수_Level1 {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();

        for (String player : participant) {
            map.put(player, map.getOrDefault(player, 0) + 1);
        }

        for (String player : completion) {
            map.put(player, map.get(player) - 1);
        }

        return map.entrySet().stream()
                .filter(i -> i.getValue() != 0)
                .map(Map.Entry::getKey)
                .collect(Collectors.joining(""));
    }

    /**
     * 책 풀이
     * iterator() 순회용 호출, 첫 번째 원소를 가져오기 위한 next() 호출
     */
    public String solution2(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();

        for (String player : participant) {
            map.put(player, map.getOrDefault(player, 0) + 1);
        }

        for (String player : completion) {
            int v = map.get(player) - 1;
            map.put(player, v);
            if (v == 0) map.remove(player);
        }

        return map.keySet().iterator().next();
    }
}
