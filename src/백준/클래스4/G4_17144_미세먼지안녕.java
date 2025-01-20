package 백준.클래스4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1000정도,
 * r-> y, c-> x
 * 공기청정기는 항상 x축에 있고, y축의 2칸을 차지.
 * 공기청정기가 설치되어 있지 않은 칸에는 미세먼지가 있고, r,c에 있는 미세먼지의 양은 A r,c이다.
 *
 * <1초>
 * 미세먼지 확산이 동시에 일어남. -> 인접 4방향
 * 인접한 방향에 공기청정기가 있거나, 칸이 없으면 그 방향 X
 * 확산 양 Arc / 5?
 *
 */
import java.util.*;

public class G4_17144_미세먼지안녕 {
    private static final int[] dy = {1, -1, 0, 0};
    private static final int[] dx = {0, 0, -1, 1};
    static int n, m, t;
    static Deque<int[]> q = new ArrayDeque<>();
    static int[][] arr;
    static List<Integer> robot = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] repo = br.readLine().split(" ");
        n = Integer.parseInt(repo[0]);
        m = Integer.parseInt(repo[1]);
        t = Integer.parseInt(repo[2]);
        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] temp = br.readLine().split(" ");

            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(temp[j]);

                if (arr[i][j] == -1) {
                    robot.add(i);
                }
            }
        }

        for (int i = 0; i < t; i++) {
            check();
            spread();
            playRobot();
        }

        System.out.println(caculator());
    }

    private static void check() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] != -1 && arr[i][j] != 0) {
                    q.add(new int[] {i, j});
                }
            }
        }
    }

    private static int caculator() {
        int sum = 0;

        for (int[] ar : arr) {
            for (int a : ar) {
                sum += a;
            }
        }

        return sum + 2;
    }

    private static void spread() {
        int[][] temp = new int[n][m];

        while (!q.isEmpty()) {
            int[] tempPos = q.remove();

            int y = tempPos[0];
            int x = tempPos[1];

            if (arr[y][x] < 5) continue;

            int spread = arr[y][x] / 5;
            int count = 0;

            for (int i = 0; i < 4; i++) {
                int oy = y + dy[i];
                int ox = x + dx[i];

                if (isCheck(oy, ox) && arr[oy][ox] != -1) {
                    temp[oy][ox] += spread;
                    count++;
                }
            }

            temp[y][x] -= spread * count;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] += temp[i][j];
            }
        }
    }

    private static void playRobot() {
        int top = robot.get(0);
        //아래
        for (int i = top - 1; i > 0; i--) {
            arr[i][0] = arr[i - 1][0];
        }
        //왼쪽
        for (int i = 0; i < m - 1; i++) {
            arr[0][i] = arr[0][i + 1];
        }
        //위
        for (int i = 0; i < top; i++) {
            arr[i][m - 1] = arr[i + 1][m - 1];
        }
        //오른쪽
        for (int i = m - 1; i > 1; i--) {
            arr[top][i] = arr[top][i - 1];
        }

        arr[top][1] = 0;

        int down = robot.get(1);

        for (int i = down + 1; i < n - 1; i++) {
            arr[i][0] = arr[i + 1][0];
        }

        for (int i = 0; i < m - 1; i++) {
            arr[n - 1][i] = arr[n - 1][i + 1];
        }

        for (int i = n - 1; i > down; i--) {
            arr[i][m - 1] = arr[i - 1][m - 1];
        }

        for (int i = m - 1; i > 1; i--) {
            arr[down][i] = arr[down][i - 1];
        }

        arr[down][1] = 0;
    }

    private static boolean isCheck(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < m;
    }
}
