package PCCP.모의고사2회;

/**
 신입사원 중 2명을 선발하고 둘디 같이 공부하게 한다.
 능력치를 정수로 표현함.
 같이 공부 -> 공부 전 특력치의 합이 된다. 3, 7 -> 10 10
 선발한 2인의 교육이 끝나면 민수는 다시 2인을 선발하여 교육을 진행한다.
 중복 선발 가능
 교육 후 모든 신입 사원들의 능력치를 (최소화) 하고 싶다.
 <문제풀이흐름>
 우선순위큐 오름차순 선언 다 넣는다.
 2개 빼서 합하고 다시 넣는다
 반복한다.
 **/
import java.util.*;
public class PCCP_2_2_신입사원교육 {
	public int solution(int[] ability, int number) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for(int a : ability) {
			pq.add(a);
		}

		while(number != 0) {
			int result =  pq.remove() + pq.remove();
			pq.add(result);
			pq.add(result);
			number--;
		}

		return pq.stream()
			.mapToInt(Integer::intValue)
			.sum();
	}
}
