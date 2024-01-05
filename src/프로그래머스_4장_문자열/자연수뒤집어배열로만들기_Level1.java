package 프로그래머스_4장_문자열;

import java.util.*;
public class 자연수뒤집어배열로만들기_Level1 {
    public int[] solution(long n) {
        String str = String.valueOf(n);
        str = new StringBuilder(str).reverse().toString();
        String[] repo = str.split("");

        return Arrays.stream(repo)
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
