package PCCP.모의고사2회;

/**
 R -> 오른쪽 90도 회전
 L -> 왼쪽 90도 회전
 G -> 한 칸 전진
 B -> 한 칸 후진
 처음 시작 (0, 0) +y축을 향하여 놓여 있습니다.
 최종 위치의 좌푯값 (x, y)
 <문제풀이흐름>
 상     0 1 2 3
 **/
public class PCCP_2_1_실습용로봇 {
	public int[] solution(String command) {
		int[] answer = new int[2];
		int stand = 0;

		for(char c : command.toCharArray()) {
			if(c == 'R') {
				stand = (stand + 1) % 4;
			} else if(c == 'L') {
				stand = (stand - 1 + 4) % 4;
			} else if(c == 'G') {
				if(stand == 0) answer[1]++;
				else if(stand == 1) answer[0]++;
				else if(stand == 2) answer[1]--;
				else if(stand == 3) answer[0]--;
			} else if(c == 'B') {
				if(stand == 0) answer[1]--;
				else if(stand == 1) answer[0]--;
				else if(stand == 2) answer[1]++;
				else if(stand == 3) answer[0]++;
			}
		}

		return answer;
	}
}
