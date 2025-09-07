package programmers;

import java.util.HashSet;
import java.util.Set;

public class lv1_폰켓몬 {
    public int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int i : nums) {
            set.add(i);
        }

        int stand = nums.length / 2;

        if(stand >= set.size()) {
            return set.size();
        }

        return stand;
    }
}
