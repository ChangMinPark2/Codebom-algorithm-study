package 백준.그래프탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
<문제풀이흐름>
1. 인접 행렬로 만든면서 n이하인 곳은 방문처리를 해둔다.
 */
public class S1_안전영역 {

    static int n, count = 0;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];

        int max = 0;
        for (int i = 0; i <  n; i++) {
            String[] repo = br.readLine().split(" ");

            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(repo[j]);
                max = Math.max(max, graph[i][j]);
            }
        }

        for (int i = 1; i <= max; i++) {
            visited = new boolean[n][n];
            int cnt = 0;

            for (int j = 0; j < n; j++) {
                for (int z = 0; z < n; z++) {
                    if (!visited[j][z] && graph[j][z] >= i) {
                        cnt++;
                        dfs(j, z, i);
                    }
                }
            }
            count = Math.max(count, cnt);
        }
        System.out.println(count);
    }

    static void dfs(int y, int x, int height) {
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (isCheck(ny, nx) && !visited[ny][nx] && graph[ny][nx] >= height) {
                dfs(ny, nx, height);
            }
        }
    }

    static boolean isCheck(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < n;
    }
}
