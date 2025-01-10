package 백준.클래스3.re;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 테트로미노 하나를 놓아서 테트로미노가 놓인 칸에 쓰여있는 수들의 합의 최댓값
 * 하나만 놓는다, 회전이나 대칭시켜도 된다.
 */
public class G4_14500_re {
    private static final int[] dx = {0, 0, -1, 1};
    private static final int[] dy = {1, -1, 0, 0};
    static int n, m;
    static int[][] arr;
    static boolean[][] visited;
    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        n = Integer.parseInt(temp[0]);
        m = Integer.parseInt(temp[1]);
        arr = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String[] repo = br.readLine().split(" ");

            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(repo[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = true;
                dfs(i, j, 0, arr[i][j]);
                visited[i][j] = false;
                com(0, 0, i, j, arr[i][j]);
            }
        }

        System.out.println(answer);
    }

    private static void com(int depth, int start, int y, int x, int sum) {
        if (depth == 3) {
            answer = Math.max(answer, sum);
            return;
        }

        for (int i = start; i < 4; i++) {
            int ny = dy[i] + y;
            int nx = dx[i] + x;

            if (isCheck(ny, nx)) {
                com(depth + 1, i + 1, y, x, sum + arr[ny][nx]);
            }
        }
    }

    private static void dfs(int y, int x, int depth, int sum) {
        if (depth == 3) {
            answer = Math.max(answer, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int ny = dy[i] + y;
            int nx = dx[i] + x;

            if (isCheck(ny, nx) && !visited[ny][nx]) {
                visited[ny][nx] = true;
                dfs(ny, nx, depth + 1, sum + arr[ny][nx]);
                visited[ny][nx] = false;
            }
        }
    }

    private static boolean isCheck(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < m;
    }
}
