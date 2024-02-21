package 코드봄.탐색;
/**
 인접행렬로 구성된 무방향 그래프 computers를 dfs로 돌리며 호출횟수를 구하면 되는 문제이다.
 <문제풀이흐름>
 반복문을 N까지 돌리며 i가 방문하지 않았다면 dfs를 돌린다. count++;
 dfs를 돌리면서 방문처리 하고,
 i를 방문하지 않았고, 1이라면 dfs 호출
 **/
public class Level3_네트워크 {
    boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                answer++;
                dfs(i, computers);
            }
        }
        return answer;
    }

    void dfs(int vertex, int[][] computers) {
        visited[vertex] = true;

        for(int i = 0; i < computers[vertex].length; i++) {
            if(!visited[i] && computers[vertex][i] == 1) {
                dfs(i, computers);
            }
        }
    }
}
