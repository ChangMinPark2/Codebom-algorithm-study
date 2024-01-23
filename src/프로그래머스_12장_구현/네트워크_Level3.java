package 프로그래머스_12장_구현;

/**
 * n개의 visit 배열,
 * false -> dfs 호출 count ++;
 * 자기 자신이 아니고, 방문을 안했고, 값이 1인 조건 -> dfs 호출
 **/
public class 네트워크_Level3 {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(computers, i, visited);
                answer++;
            }
        }
        return answer;
    }

    public boolean[] dfs (int[][] computers, int computerNumber, boolean[] visited) {
        visited[computerNumber] = true;

        for (int i = 0; i < computers.length; i++) {
            if (!visited[i] && i != computerNumber && computers[computerNumber][i] == 1) {
                visited = dfs(computers, i, visited);
            }
        }

        return visited;
    }
}
