package 백준.클래스4.re;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class G4_14502_RE {
    private static final int[] dy = {-1, 1, 0, 0};
    private static final int[] dx = {0, 0, -1, 1};
    static int n, m;
    static int[][] arr;
    static Deque<int[]> virus = new ArrayDeque<>();
    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        n = Integer.parseInt(temp[0]);
        m = Integer.parseInt(temp[1]);
        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            temp = br.readLine().split(" ");

            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(temp[j]);

                if (arr[i][j] == 2) {
                    virus.add(new int[] {i, j});
                }
            }
        }

        dfs(0);
        System.out.println(answer);
    }

    private static void dfs(int depth) {
        if (depth == 3) {
            bfs();
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    arr[i][j] = 1;
                    dfs(depth + 1);
                    arr[i][j] = 0;
                }
            }
        }
    }

    private static void bfs() {
        Deque<int[]> q = new ArrayDeque<>(virus);
        boolean[][] visited = new boolean[n][m];
        int[][] tempArr = copy();

        while (!q.isEmpty()) {
            int[] temp = q.remove();
            int oy = temp[0];
            int ox = temp[1];

            for (int i = 0; i < 4; i++) {
                int ny = oy + dy[i];
                int nx = ox + dx[i];

                if (isCheck(ny, nx) && !visited[ny][nx] && tempArr[ny][nx] == 0) {
                    visited[ny][nx] = true;
                    tempArr[ny][nx] = 2;
                    q.add(new int[] {ny, nx});
                }
            }
        }

        answer = Math.max(answer, calculator(tempArr));
    }

    private static int calculator(int[][] arr) {
        int count = 0;

        for (int[] ar : arr) {
            for (int a : ar) {
                if (a == 0) count++;
            }
        }

        return count;
    }

    private static int[][] copy() {
        int[][] tempArr = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                tempArr[i][j] = arr[i][j];
            }
        }

        return tempArr;
    }

    private static boolean isCheck(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < m;
    }
}
