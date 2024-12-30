package PCCP.모의고사1회.re;
/**
 행 -> 10, 열 -> 10,000
 데이터 갯수 10010: 탐색? 가능할듯.
 능력치의 합을 최대화하기.
 **/

public class PCCP_2번_체육대회 {
    int answer = 0;

    public int solution(int[][] ability) {
        boolean[] visited = new boolean[ability.length];

        dfs(ability, visited, 0, 0);

        return answer;
    }

    private void dfs(int[][] map, boolean[] visited, int sum, int depth) {
        if(depth == map[0].length) {
            answer = Math.max(answer, sum);
            return;
        }

        for(int i = 0; i < map.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(map, visited, sum + map[i][depth], depth + 1);
                visited[i] = false;
            }
        }
    }
}
