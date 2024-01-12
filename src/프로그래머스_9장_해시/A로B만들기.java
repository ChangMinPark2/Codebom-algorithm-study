package 프로그래머스_9장_해시;

import java.util.*;

public class A로B만들기 {
    public static int solution(String before, String after) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : before.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : after.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) - 1);
        }
        System.out.println(map);

        for (int i : map.values()) {
            if (i != 0) return 0;
        }

        return 1;
    }

    public static void main(String[] args) {
        String before = "apple";
        String after = "allpe";

        System.out.println(solution(before, after));
    }


}
