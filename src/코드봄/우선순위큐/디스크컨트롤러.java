package 코드봄.우선순위큐;

import java.util.*;

/**
 * <문제풀이흐름>
 * [요청 시점, 작업의 소요 시간] 작업의 요청부터 종료까지 걸린 시간의 평균이 가장 낮은 값.
 * 하드 디스크가 작업을 수행하지 않을 때는 먼저 요청이 들어온 작업부터 처리한다.
 * 요청이 들어온 작업 중에서 수행 시간이 짧은 것을 선택하는 문제이다.
 * <p>
 * 배열의 요청시간이 짧은 순으로 온다는 말이 없다. -> 0번째 인덱스 기준 오름차순 정렬
 * 작업이 끝나는 시점에 요청이 들어온 작업 중 작업의 소요 시간이 낮은 선택.
 * -> (요청이 들어온 작업 중) pq 1번째 인덱스 기준 최솟값을 가지는 힙 선언
 */
public class 디스크컨트롤러 {

    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        int sum = 0; // 최종 합
        int count = 0; // 작업 수
        int standard = 0; // 요청 시간
        int index = 0;

        while (count < jobs.length) {

            while (index < jobs.length && jobs[index][0] <= standard) {
                pq.add(jobs[index]);
                index++;
            }

            if (!pq.isEmpty()) {
                int[] arr = pq.poll(); // 요청시간이 들어왔고, 수행시간이 가장 낮은 작업.
                sum += standard - arr[0] + arr[1];
                standard += arr[1];
                count++;
            } else {
                standard = jobs[index][0];
            }
        }
        System.out.println(sum);
        return sum / jobs.length;
    }
}
