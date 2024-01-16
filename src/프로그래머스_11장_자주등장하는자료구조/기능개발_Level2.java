package 프로그래머스_11장_자주등장하는자료구조;
/**
 <문제풀이흐름>
 두 배열을 순서대로 참조할 수 있도록 큐에 인덱스를 넣어준다.
 **/
import java.util.*;
public class 기능개발_Level2 {
    public int[] solution(int[] progresses, int[] speeds) {
        // 0 1 2 3 4 5
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < progresses.length; i++) {
            q.add(i);
        }

        List<Integer> answer = new ArrayList<>();
        int days = 0;
        int count = 0;

        while(!q.isEmpty()) {
            int index = q.poll();
            int expiration = (int) Math.ceil(
                    (double) (100 - progresses[index]) / speeds[index]);

            if(expiration > days) {
                if(days != 0) {
                    answer.add(count);
                    count = 0;
                }
                days = expiration;
            }
            count++;
        }

        answer.add(count);
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
