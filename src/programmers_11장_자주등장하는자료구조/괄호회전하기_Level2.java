package programmers_11장_자주등장하는자료구조;

/**
 <문제풀이흐름>
 1. check 메소드
 여는괄호면 닫는 괄호를 푸쉬한다.
 닫는괄호면 비어있는지 체크하고, false
 pop값이랑 c가 다르면 false
 **/
import java.util.*;

public class 괄호회전하기_Level2 {
    public int solution(String s) {
        char[] str = s.toCharArray();
        int count = 0;

        for (int i = 0; i < str.length; i++) {
            if(isCheck(str, i)) count++;
        }

        return count;
    }

    private boolean isCheck(char[] str, int index) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < str.length; i++) {
            char c = str[(index + i) % str.length];
            if(c == '(') stack.push(')');
            if(c == '{') stack.push('}');
            if(c == '[') stack.push(']');
            if(c == ')' || c == ']' || c == '}') {
                if(stack.isEmpty()) return false;
                if(stack.pop() != c) return false;
            }
        }

        return stack.isEmpty();
    }
}
