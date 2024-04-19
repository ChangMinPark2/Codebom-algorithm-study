package PCCP;

/**
 (둥근 완두 순종)RR -> 자가 수분, 같은 유전자 끼리 교배하면 다음 세대에 둥근 완두만 나옴.
 (주름진 완두 순종)rr -> 다음 세대에 주름진 완두 순종만 나타남
 잡종일 경우 -> Rr이 나온다.
 총 3종류 (RR, Rr, rr)
 완두콩의 세대(Depth)와, (해당 세대에서 몇 번째 개체인지 알면)
 depth의 최댓값 16
 <문제풀이흐름>
 시작은 Rr (루트 노드)
 그래프를 어떻게 채울까? (애매하다)
 깊이가 1일 때 노드 1 4의 0승
 2 -> 4 4의 1승
 3 -> 16 4의 2승 (0 ~ 3)=one (4 ~ 8)two (9 ~ 12)three (13 ~ 16)four
 3 -> Math.pow(4, i - 1);
 16 / 1 2 3 4 = 2
 **/
public class PCCP_1_3번_유전법칙 {
	public String[] solution(int[][] queries) {
		String[] result = new String[queries.length];

		for (int i = 0; i < queries.length; i++) {
			if(queries[i][0] == 1){
				result[i] = "Rr";
			}
			if (queries[i][0] == 2) {
				result[i] = "rr";
			}
			int stand = (int) Math.pow(4, queries[i][0] - 1);

			result[i] = recursive(queries[i][0], queries[i][1]);
		}

		return result;
	}
//0, 1, 1 : 4, 2: 16, 3: 64
	private String recursive(int n, int p) {
		int cnt = (int)Math.pow(4, n - 1);

		if (p <= cnt / 4) // 첫 번째 덩어리
			return "RR"; //ok
		if (p > cnt / 4 * 3) //마지막 덩어리
			return "rr"; //ok
		if (n == 2) //
			return "Rr";
		if(n == 1)
			return "Rr";

		if (p > cnt / 4 && p <= cnt / 2) {
			return recursive(n - 1, p - cnt / 4);
		}

		return recursive(n - 1, p - cnt / 2);
	}
}
