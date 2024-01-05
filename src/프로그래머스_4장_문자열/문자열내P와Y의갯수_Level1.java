package 프로그래머스_4장_문자열;

/**
 <문제 풀이 흐름>
 1. p의 갯수를 센다
 2. y의 갯수를 센다
 3. 대소문자 구분은 없으며, 같으면 true 다르면 false를 리턴한다. 둘다 0이면 true를 리턴한다.
 **/
public class 문자열내P와Y의갯수_Level1 {
    boolean solution(String s) {
        s = s.toUpperCase();

        return Pcount(s) == Ycount(s);
    }

    private int Pcount (String s){
        return (int) s.chars()
                .filter(o -> o == 'P')
                .count();
    }
    private int Ycount (String s){
        return (int) s.chars()
                .filter(o -> o == 'Y')
                .count();
    }

    boolean solution2(String s) {
        s = s.toUpperCase();

        return s.chars().filter(o -> o == 'P').count() ==
                s.chars().filter(o -> o == 'Y').count();
    }
}
