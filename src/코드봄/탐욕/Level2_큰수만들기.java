package 코드봄.탐욕;
/**
 * <문제풀이흐름>
 * 1. 스택에 있는 값이, 다음 값보다 작으면 pop 한다. (k만큼 뺴줘야 하니 k--)
 * 2. 스택이 비어있으면 push 한다.
 * 3. 스택 값 순서대로 출력.
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
        ArrayDeque<Character> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            while (!stack.isEmpty() && stack.peek() < c && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(solution2("1924", 2));
    }
}
