package 프로그래머스;
import java.util.*;

public class Lv2_롤케이크자르기 {
    public int solution(int[] topping) {
        int answer = 0;

        Set<Integer> bro = new HashSet<>();
        Map<Integer,Integer> map = new HashMap<>();

        for(int i : topping) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for(int i : topping) {
            bro.add(i);
            map.put(i, map.get(i) - 1);

            if(map.get(i) == 0) {
                map.remove(i);
            }

            if(bro.size() == map.size()) {
                answer++;
            }
        }

        return answer;
    }
}
