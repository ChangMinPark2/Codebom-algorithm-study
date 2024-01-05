package 프로그래머스_4장_문자열;

import java.util.*;

public class 자연수뒤집어배열로만들기_Level1 {
    public int[] solution(long n) {
        String str = new StringBuilder(String.valueOf(n)).reverse().toString();
        String[] repo = str.split("");

        return Arrays.stream(repo)
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public int[] bookSolution(long n) {
        String str = Long.toString(n);
        String reversed = new StringBuilder(str).reverse().toString();
        char[] arr = reversed.toCharArray();

        int[] result = new int[arr.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = arr[i] - '0';
        }
        return result;
    }
}
