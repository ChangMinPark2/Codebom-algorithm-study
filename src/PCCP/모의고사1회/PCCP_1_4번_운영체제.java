package PCCP.모의고사1회;
/**
 우선 순위와 호출된 시각에 따라 실행 순서 결정
 모든 프로그램 1 ~ 10의 점수 (우선순위임 낮을수록 높다.)
 프로그램이 호출되면, 대기상태에 있다가 자신의 순서가 되면 실행 시간 동안 실행된 뒤 종료
 1. 우선순위가 가장 높은 것 부터 실행
 2. 각 프로그램은 앞에 프로그램이 모두 종료된 후에 실행됨
 3. 프로그램은 중단되지 않고 종료될 떄 까지 실행.
 4. 우선순위가 같으면 먼저 호출된게 실행.
 return -> 모든 프로그램이 종료 시간, i(우선순위) 마다 대기시간
 <문제풀이흐름>
 호출된 프로그램들 중에서, 우선순위 기준으로 넣음
 우선순위가 같다면, 먼저 호출 된 것 [1] 기준으로 실행됨
 **/
import java.util.*;

public class PCCP_1_4번_운영체제 {
	public long[] solution(int[][] program) {
		long[] answer = new long[11];
		long total = 0;
		//우선순위
		PriorityQueue<int[]> pq = new PriorityQueue<>(
			(o1, o2) -> {
				if (o1[0] == o2[0]) { //우선순위가 같다면 호출 순으로.
					return o1[1] - o2[1];
				}
				return o1[0] - o2[0];
			}
		);

		//호출순 기준
		PriorityQueue<int[]> wait = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

		for(int[] arr : program) {
			wait.add(arr);
		}

		long time = -1;
		int run = 0;

		while(true) {
			if(wait.isEmpty() && pq.isEmpty() && run == 0) {
				break;
			}
			time++;

			if (run != 0) {
				run--;
			}

			// pq가 호출되는 시점.
			while (!wait.isEmpty() && wait.peek()[1] == time) {
				pq.add(wait.remove());
			}

			// 실행중인 pq가 종료되는 시점
			if(run == 0 && !pq.isEmpty()) {
				int[] temp = pq.remove();
				run += temp[2];
				answer[temp[0]] += time - temp[1];
			}
		}

		answer[0] = time;

		return answer;
	}
}
