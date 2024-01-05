package 프로그래머스_4장_문자열;

/**
 <문제 풀이 흐름>
 1. p의 갯수를 센다
 2. y의 갯수를 센다
 3. 대소문자 구분은 없으며, 같으면 true 다르면 false를 리턴한다. 둘다 0이면 true를 리턴한다.
 **/
public class 문자열내P와Y의갯수 {
    boolean solution(String s) {
        s = s.toUpperCase();

        int p = Pcount(s);
        int y = Ycount(s);

        if(p == y && p == 0) return true;

        return p == y;
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
}
