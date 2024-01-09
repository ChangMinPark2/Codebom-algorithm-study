package 프로그래머스_7장_정렬;

/**
 <문제풀이흐름>
 이중 반복문을 통해 더한 값을 모두 List에 넣어준다.
 sort하고 중복을 제거해준다.
 **/

import java.util.*;

public class 두개뽑아서더하기_Level1 {
    public int[] solution(int[] numbers) {
        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < numbers.length - 1; i++) {
            for(int j = i + 1; j < numbers.length; j++){
                set.add(numbers[i] + numbers[j]);
            }
        }

        return set.stream()
                .sorted()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
