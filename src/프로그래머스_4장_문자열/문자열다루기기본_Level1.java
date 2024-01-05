package 프로그래머스_4장_문자열;

/**
 <문제 풀이 흐름>
 문자열 길이가 4 혹은 6 이면서, 숫자로만 구성 되어 있는가?
 **/
public class 문자열다루기기본_Level1 {
    public boolean solution(String s) {
        if(s.length() != 4 && s.length() != 6) return false;

        return s.matches("\\d+");
    }
}
