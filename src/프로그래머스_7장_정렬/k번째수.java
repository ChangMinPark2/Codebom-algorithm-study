package 프로그래머스_7장_정렬;

import java.util.*;

/**
 * <문제풀이흐름>
 * 인덱스 기준이 아닌 숫자 기준으로써 - 1 을 해준다 (sort 해줄 때)
 * 배열 [i j k]를 원소로 가진 2차원 배열이 주어진다.
 **/
public class k번째수 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int[] repo = array.clone();
            Arrays.sort(repo, commands[i][0] - 1, commands[i][1]);
            System.out.println(Arrays.toString(repo));
            answer[i] = repo[commands[i][2] - 1 + commands[i][0] - 1];
        }

        return answer;
    }
}
