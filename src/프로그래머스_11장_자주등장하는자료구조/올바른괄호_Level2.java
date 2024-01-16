package 프로그래머스_11장_자주등장하는자료구조;
/**
 * <문제풀이흐름>
 * 스택 선언
 * (이면 푸쉬  )이면 팝
 * 조건 추가 -> 스택이 비어있을 때 ) 이 들어오면 false 리턴
 **/

import java.util.*;

public class 올바른괄호_Level2 {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(') stack.push(c);

            if (c == ')') {
                if (stack.isEmpty()) return false;

                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
