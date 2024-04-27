package PCCP.모의고사2회;

/**
 얼마나 많은 손님들이 동시에 있는가를 본다
 0초에 1명이 오고, k 초마다 한 명씩 온다.
 키오스크를 통해 주문, 주문 받은 순서대로 음료를 만든다.
 한 번에 하나씩 음료를 만들고 다 만들고 나서 다음 음료를 만든다.
 손님은 음료를 받자마자 나간다.
 어러종류의 음료, 0번부터 차례대로 번호가 있음. 같은 종류의 음료는 걸리는 시간은 항상 동일.
 (받은 주문 음료 목록을 이용해 동시에 최대 몇명이 머물렀는가를 본다.)
 (손님이 주문하기 까지 시간, 음료를 받은 후 카페를 나가는 시간) 무시
 나감과 동시에 들어오면 나가고 들어온다.
 menu -> (인덱스 기준) 걸리는 음료의 시간
 order -> 들어온 순서대로 주문한 음료
 k-> k초마다 들어옴.
 <문제풀이흐름>
 사람이 입장하는 경우 (자신이 입장할 차례이고, 주문이 끝났을 떄)
 **/
import java.util.*;

public class PCCP_2_3 {
	public int solution(int[] menu, int[] order, int k) {
		int answer = 0;
		int time = 0;
		int index = 0;
		int out = 0;
		int stand = 0;
		int count = 0;
		List<Integer> list = new ArrayList<>();

		for(int i = 0; i < order.length; i++) {
			stand += menu[order[i]];
		}

		while(time != stand + 1) {
			//나가는 경우 (나가기 전을 체크)
			if(time == out) {
				if(answer > 0) {
					list.add(answer); // 여기 안에 max를 구해야겠다.
					answer--;
				}

				if(index < order.length) {
					out += menu[order[index++]];
				}
			}

			//사람이 기다릴 떄
			if(time % k == 0 && count != order.length) {
				answer++;
				count++;
			}

			time++;
		}
		list.add(answer);
		Collections.sort(list);

		return list.get(list.size() - 1);
	}
}
