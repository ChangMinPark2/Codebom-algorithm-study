package 프로그래머스_4장_문자열;
/**
 <문제 풀이 흐름>
 1. 10진수 n을 3진수로 변환한다.
 2. 3진수를 뒤집는다.
 3. 뒤집은 3진수를 다시 10진법으로 표현해서 리턴한다.
 **/
public class 삼진법뒤집기_Level1 {
    public int solution(int n) {
        String three = Integer.toString(n, 3);
        three = new StringBuilder(three).reverse().toString();
        return Integer.valueOf(three, 3);
    }
}

