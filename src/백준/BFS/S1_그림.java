package 백준.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class S1_그림 {
    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};  // 상하좌우
    static int[] dy = {1, -1, 0, 0};
    static int count = 0;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] repo = br.readLine().split(" ");
        n = Integer.parseInt(repo[0]); //6
        m = Integer.parseInt(repo[1]); //5
        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String[] repo2 = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(repo2[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j] == 1 && !visited[i][j]) {
                    max = Math.max(max, bfs(i, j));
                    count++;
                }
            }
        }

        System.out.println(count);
        System.out.println(max);
    }

    static int bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x, y});
        visited[x][y] = true;
        int size = 1;

        while (!q.isEmpty()) {
            int[] temp = q.remove();
            int qx = temp[0];
            int qy = temp[1];

            for (int i = 0; i < 4; i++) {
                int ax = qx + dx[i];
                int ay = qy + dy[i];

                if (isCheck(ax, ay) && !visited[ax][ay] && map[ax][ay] == 1) {
                    visited[ax][ay] = true;
                    size++;
                    q.add(new int[]{ax, ay});
                }
            }
        }
        return size;
    }

    private static boolean isCheck(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}
