package 코드봄.해시;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 1. 참여자들을 +1 해준다.
 * 2. 완주자들을 -1 해준다.
 * 3. value 값이 0이 아닌 것을 리턴한다.
 */
public class 완주하지못한선수 {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();

        for (String name : participant) {
            map.put(name, map.getOrDefault(name, 0) + 1);
        }

        for (String name : completion) {
            map.put(name, map.get(name) - 1);
        }

        return map.entrySet().stream()
                .filter(o -> o.getValue() != 0)
                .map(Map.Entry::getKey)
                .collect(Collectors.joining(""));
    }
}
