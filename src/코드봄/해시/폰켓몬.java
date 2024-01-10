package 코드봄.해시;

import java.util.*;
import java.util.stream.Collectors;

/**
 1. nums를 set에 넣는다
 2. map 사이즈와 max중 작은 것을 리턴
 **/
public class 폰켓몬 {
    public int solution(int[] nums) {
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());

        return Math.min(nums.length / 2, set.size());
    }
}
