package 백준;

import java.io.*;
import java.util.*;

/**
 * 최단 거리를 구하는 문제. 1로만 이동할 수 있다.
 * N, M을 입력값으로 받는다.
 * 그래프를 인접행렬로 만든후 탐색하여 만든 x,y가 == 4,4 라면 종료시킨다.
 */
public class 미로탐색 {
    static boolean[][] visited;
    static int[][] graph;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int count, n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] repo = br.readLine().split(" ");

        n = Integer.parseInt(repo[0]);
        m = Integer.parseInt(repo[1]);
        visited = new boolean[n][m];
        graph = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] repo2 = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(repo2[j]);
            }
        }

        bfs(graph);

        System.out.println(count);
    }

    static void bfs(int[][] graph) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0, 1});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] temp = queue.remove();
            int nx = temp[0];
            int ny = temp[1];
            count = temp[2];

            if (nx == n - 1 && ny == m - 1) {
                break;
            }

            for (int i = 0; i < 4; i++) {
                int x = nx + dx[i];
                int y = ny + dy[i];

                if (isCheck(x, y) && !visited[x][y] && graph[x][y] == 1) {
                    visited[x][y] = true;
                    queue.add(new int[] {x, y, count+1});
                }
            }
        }
    }

    private static boolean isCheck(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}
