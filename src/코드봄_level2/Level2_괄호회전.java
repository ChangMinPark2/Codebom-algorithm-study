package 코드봄_level2;
import java.util.*;

public class Level2_괄호회전 {
	public int solution(String s) {
		char[] str = s.toCharArray();
		int count = 0;

		for (int i = 0; i < str.length; i++) {
			if(isCheck(str, i)) count++;
		}

		return count;
	}

	private boolean isCheck(char[] str, int start) {
		Deque<Character> stack = new ArrayDeque<>();

		for(int i = 0; i < str.length; i++) {
			char c = str[(start + i) % str.length];
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
