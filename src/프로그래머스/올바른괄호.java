package 프로그래머스;
import java.util.*;
public class 올바른괄호 {
    boolean solution(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for(char c : s.toCharArray()) {
            if(c == '(') stack.push(c);

            if(c == ')'){
                if(stack.isEmpty()) return false;
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}
