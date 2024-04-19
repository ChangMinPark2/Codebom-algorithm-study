package PCCP;

public class PCCP_1_2_체육대회 {
	public int solution(int[][] ability) {
		boolean[] visited = new boolean[ability.length];
		return dfs(0, 0, ability, visited);

	}

	private int dfs(int depth, int sum, int[][] map, boolean[] visited) {
		if(depth == map[0].length) {
			return sum;
		}

		int answer = 0;

		for(int i = 0; i < map.length; i++) {
			if(!visited[i]) {
				visited[i] = true;
				answer = Math.max(answer, dfs(depth + 1, sum + map[i][depth], map, visited));
				visited[i] = false;
			}
		}

		return answer;
	}
}
