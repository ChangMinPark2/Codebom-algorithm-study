package 프로그래머스;

import java.util.*;

public class 게임맵최단거리_BFS_re {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static boolean[][] visited;
    static int n, m, count;

    public static int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        visited = new boolean[n][m];
        bfs(maps);

        return !visited[n - 1][m - 1] ? -1 : count;
    }

    static void bfs(int[][] maps) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 1});
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] arr = q.remove();
            int y = arr[0];
            int x = arr[1];
            count = arr[2];

            if (y == n - 1 && x == m - 1) break; //목적지 도착 종료조건.

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (isCheck(ny, nx) && !visited[ny][nx] && maps[ny][nx] == 1) {
                    visited[ny][nx] = true;
                    q.add(new int[]{ny, nx, count + 1});
                }
            }
        }
    }

    static boolean isCheck(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < m;
    }

    public static void main(String[] args) {
        int[][] maps = {
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1},
                {0, 0, 0, 0, 1}
        };

        System.out.println(solution(maps));
    }
}
