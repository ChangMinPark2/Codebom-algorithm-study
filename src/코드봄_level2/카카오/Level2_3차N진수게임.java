package 코드봄_level2.카카오;

/**
 0 ~ 9
 1 0 1 1 1 2 1 3 1 4 1 5
 0 1 10 11 100 101 110 111
 2진법에서 16진법 까지 모든 진법으로 게임을 진행한다.
 자신이 말해야 하는 숫자를 스마트폰에 미리 출력해주는 프로그램을 만드려고 한다.
 n 진법, 미리 구할 숫자의 갯수 t, 게임에 참가하는 인원 m, 튜브의 숫서 p
 0, 0, 0
 1, 1, 1
 2, 10, 1
 3, 11, 1
 4, 100 , 1   -> 0, 1, 1, 1
 t * m 이 필요.(말할 숫자 * 총 인원 수)

 **/
public class Level2_3차N진수게임 {
	public String solution(int n, int t, int m, int p) {
		StringBuilder sb = new StringBuilder();
		int num = 0;

		while(sb.length() < t * m) {
			String temp = Integer.toString(num, n).toUpperCase();
			sb.append(temp);
			num++;
		}

		String str = sb.substring(0, t * m);
		StringBuilder answer = new StringBuilder();

		for(int i = p - 1; i < str.length(); i += m) {
			char c = str.charAt(i);
			answer.append(c);
		}

		return answer.toString();

	}
}
