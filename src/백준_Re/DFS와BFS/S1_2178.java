package 백준_Re.DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 4 6
 * 101111
 * 101010
 * 101011
 * 111011
 */
public class S1_2178 {
    static int n;
    static int m;
    static final int[] dx = {0, 0, -1, 1};
    static final int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] repo = br.readLine().split(" ");
        n = Integer.parseInt(repo[0]);
        m = Integer.parseInt(repo[1]);
        int[][] arr = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String[] temp = br.readLine().split("");

            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(temp[j]);
            }
        }

        System.out.println(bfs(arr, visited));
    }

    static int bfs(int[][] arr, boolean[][] visited){
        visited[0][0] = true;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 1});

        while (!q.isEmpty()) {
            int[] temp = q.remove();
            int y = temp[0];
            int x = temp[1];
            int score = temp[2];

            if (y == n - 1 && x == m - 1) {
                return score;
            }

            for (int i = 0; i < 4; i++) {
                int ox = x + dx[i];
                int oy = y + dy[i];

                if (isCheck(oy, ox)&& !visited[oy][ox] && arr[oy][ox] == 1) {
                    visited[oy][ox] = true;
                    q.add(new int[] {oy, ox, score + 1});
                }
            }

        }
        return -1;
    }

    static boolean isCheck(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < m;
    }
}
