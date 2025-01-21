package 백준.클래스4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Queue;

/**
 * n,m <= 8
 * 0빈칸, 1빈칸, 2바이러스
 */
public class G4_14502_연구소 {
    private static int[] dy = {-1, 1, 0, 0};
    private static int[] dx = {0, 0, -1, 1};
    static int[][] arr;
    static int[][] tempArr;
    static boolean[][] visited;
    static int n, m;
    static Deque<int[]> q = new ArrayDeque<>();
    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] repo = br.readLine().split(" ");
        n = Integer.parseInt(repo[0]);
        m = Integer.parseInt(repo[1]);

        arr = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String[] temp = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(temp[j]);
                if (arr[i][j] == 2) {
                    q.add(new int[]{i, j});
                }
            }
        }

        dfs(0);

        System.out.println(answer);
    }

    private static void dfs(int depth) {
        if (depth == 3) {
            bfs();
            count();
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
        Deque<int[]> tempQ = new ArrayDeque<>(q);
        boolean[][] tempVisited = new boolean[n][m];
        tempArr = deepCopy();

        while (!tempQ.isEmpty()) {
            int[] temp = tempQ.remove();
            int ny = temp[0];
            int nx = temp[1];

            for (int i = 0; i < 4; i++) {
                int oy = ny + dy[i];
                int ox = nx + dx[i];

                if (isCheck(oy, ox) && arr[oy][ox] == 0 && !tempVisited[oy][ox]) {
                    tempVisited[oy][ox] = true;
                    tempArr[oy][ox] = 2;
                    tempQ.add(new int[]{oy, ox});
                }
            }
        }
    }

    private static void count() {
        int sum = 0;

        for (int[] ar : tempArr) {
            for (int a : ar) {
                if (a == 0) {
                    sum++;
                }
            }
        }

        answer = Math.max(answer, sum);
    }

    private static boolean isCheck(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < m;
    }

    private static int[][] deepCopy() {
        int[][] copy = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                copy[i][j] = arr[i][j];
            }
        }

        return copy;
    }
}
