package 코드봄.탐욕;
/**
 * <문제풀이흐름>
 * 1. number를 인트배열로 내림차순하여 정렬한다.
 * 2. k까지 숫자를 리턴한다.
 **/

import java.util.*;
import java.util.stream.Collectors;

public class Level2_큰수만들기 {
    public static String solution(String number, int k) {
        List<Integer> list = Arrays.stream(number.split(""))
                .mapToInt(Integer::parseInt)
                .boxed()
                .sorted(((o1, o2) -> o2 - o1))
                .collect(Collectors.toList());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < k; i++) {
            sb.append((list.get(i)));
        }

        return sb.toString();
    }

    public static String solution2(String number, int k) {
        char[] result = new char[number.length() - k];
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            while (!stack.isEmpty() && stack.peek() < c && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }

        for (int i = 0; i < result.length; i++) {
            result[i] = stack.get(i);
        }
        return new String(result);
    }

    public static void main(String[] args) {
        System.out.println(solution2("1924", 2));
    }
}
