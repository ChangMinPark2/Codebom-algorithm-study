package 코드봄.스택큐;

import java.util.*;

/**
 * 우선순위큐 -> 내림차순 원소넣기.
 * 큐의 값과, 배열 값을 큐가 빌 때 까지 순회하며 ++해준다.
 * 인덱스와 location이 같으면 반환한다.
 */
public class 프로세스 {
    public int solution(int[] priorities, int location) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for (int i : priorities){
            pq.add(i);
        }

        while (!pq.isEmpty()){
            for (int i = 0; i< priorities.length; i++){
                if (priorities[i] == pq.peek()){
                    pq.poll();
                    answer++;

                    if (i == location)
                        return answer;
                }

            }
        }

        return 0;
    }
}
