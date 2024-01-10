package 코드봄.해시;

import java.util.*;

/**
 * <문제 풀이 흐름>
 * 1. 옷을 종류별로 구분한다. <String, Integer>
 * 2. 모든 경우의 수를 구한다.
 * 3. 아무것도 안 입은 경우를 빼준다.
 * <제한사항>
 * 중복된 의상은 존재하지 않는다.
 * 각 종류별로 최대 1가지 의상만 착용할 수 있다.
 * 최소 한 개 이상 입는다.
 **/
public class 의상 {
    public static int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();

        for (String[] clothe : clothes) {
            String type = clothe[1];

            map.put(type, map.getOrDefault(type, 1) + 1);
        }
        int answer = 1;

        for (String key : map.keySet()) {
            answer *= map.get(key);
        }
        return answer - 1;
    }
}
