package 백준_Re;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class S1_그림 {
    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static int count = 0;
    static int max = 0;
    static final int[] dx = {0, 0, -1, 1};
    static final int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] repo = br.readLine().split(" ");
        n = Integer.parseInt(repo[0]); // 세로 = y
        m = Integer.parseInt(repo[1]); // 가로 = x
        map = new int[n][m];
        visited = new boolean[n][m];

        //맵 채움
        for (int i = 0; i < n; i++) {
            String[] repo2 = br.readLine().split(" ");

            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(repo2[j]);
            }
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    bfs(i, j);
                    count++;
                }
            }
        }

        System.out.println(count);
        System.out.println(max);
    }

    static void bfs(int y, int x) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {y, x});
        visited[y][x] = true;
        int size = 1;

        while (!q.isEmpty()) {
            int[] temp = q.poll();

            int ny = temp[0];
            int nx = temp[1];

            for (int i = 0; i < 4; i++) {
                int oy = ny + dy[i];
                int ox = nx + dx[i];

                if (isCheck(oy, ox) && !visited[oy][ox] && map[oy][ox] == 1) {
                    visited[oy][ox] = true;
                    q.add(new int[] {oy, ox});
                    size++;
                }
            }
        }

        max = Math.max(max, size);
    }

    static boolean isCheck(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < m;
    }
}
