package 백준.클래스3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1,1 시작 -> n,m 으로 지날 때, 최소의 칸 수
 * bfs, 종료조건, sum 필요
 * n,m = 100 -> 인접행렬 가능
 */
public class S1_2178_미로탐색 {
    private final static int[] dx = {0, 0, -1, 1};
    private final static int[] dy = {1, -1, 0, 0};
    static int n, m;
    static boolean[][] visited;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] repo = br.readLine().split(" ");
        n = Integer.parseInt(repo[0]);
        m = Integer.parseInt(repo[1]);
        visited = new boolean[n][m];
        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] temp = br.readLine().split("");

            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(temp[j]);
            }
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0, 1});
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] temp = q.remove();

            int y = temp[0];
            int x = temp[1];
            int score = temp[2];

            if (y == n - 1 && x == m - 1) {
                return score;
            }

            for (int i = 0; i < 4; i++) {
                int oy = dy[i] + y;
                int ox = dx[i] + x;

                if (isCheck(oy, ox) && !visited[oy][ox] && arr[oy][ox] == 1) {
                    visited[oy][ox] = true;
                    q.add(new int[]{oy, ox, score + 1});
                }
            }
        }

        return 0;
    }

    private static boolean isCheck(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < m;
    }
}
