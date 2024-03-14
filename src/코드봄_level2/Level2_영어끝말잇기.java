package 코드봄_level2;

import java.util.*;
/**
 1 ~ n 명의 사람이 끝말잇기를 한다.
 순서대로 차례로 단어를 말한다.
 마지막 사람이 단어를 말하면, 다시 1번부터 시작한다.
 1. 한 번 사용한 단어는 사용할 수 없다.
 2. 한 글자인 단어는 인정되지 않는다.
 return값 가장 먼저 탈락하는 사람의 번호, 몇 번째 차례에서 탈락하는지
 <문제풀이흐름>
 1. Set 넣기 전 체크
 2. i % n + 1 , i / n + 1;
 3. 리턴
 **/
public class Level2_영어끝말잇기 {
    public static int[] solution(int n, String[] words) {
        int standard = -1;
        Set<String> set = new HashSet<>();

        for(int i = 0; i < words.length; i++) {
            if(set.contains(words[i])) {
                standard = i;
                break;
            }

            if(i < words.length - 1 && words[i].charAt(words[i].length() - 1) != words[i + 1].charAt(0)) {
                standard = i + 1;
                break;
            }
            set.add(words[i]);
        }

        if(standard == -1) return new int[] {0, 0};
        return new int[]{(standard % n) + 1 , standard / n + 1};
    }

    public static void main(String[] args) {
        String[] arr = {
                "tank", "tick", "know", "wheel", "land", "dream", "mother", "robot", "tank"
        };
        System.out.println(Arrays.toString(solution(3, arr)));
    }

}
