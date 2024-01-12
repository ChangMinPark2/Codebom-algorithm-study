package 프로그래머스_9장_해시;
import java.util.*;
import java.util.stream.Collectors;

public class 없는숫자더하기 {

    //내가 푼 풀이
    public int solution(int[] numbers) {
        return 45 - Arrays.stream(numbers).sum();
    }

    //해쉬 책 버번
    public int solution2(int[] numbers) {
        Set<Integer> set = Arrays.stream(numbers).boxed().collect(Collectors.toSet());

        int sum = 0;
        for(int i = 0; i <=9; i++) {
            if (set.contains(i)) continue;
            sum += i;
        }
        return sum;
    }
}
