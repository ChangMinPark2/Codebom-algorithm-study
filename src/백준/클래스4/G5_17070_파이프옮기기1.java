package 백준.클래스4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * n < 16 백
 * n*n 맵.
 * 빈칸 or 벽
 * 방향 -> 오른쪽, 아래, 오른쪽 아래 대각선
 *
 */
public class G5_17070_파이프옮기기1 {
    private static int n;
    private static int[][] arr;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] repo = br.readLine().split(" ");

            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(repo[j]);
            }
        }

        bfs();

        System.out.println(count);
    }

    private static void bfs() {
        Deque<int[]> q = new ArrayDeque<>();
        // y, x, y1, y2
        q.add(new int[] {0, 0, 0, 1});

        while (!q.isEmpty()) {
            int[] temp = q.remove();
            int y1 = temp[0];
            int x1 = temp[1];
            int y2 = temp[2];
            int x2 = temp[3];

            if (y2 == n - 1 && x2 == n - 1) {
                count++;
            }
            //가로라면
            if (y1 == y2 && x1 + 1 == x2) {
                // 오른쪽
                if (isCheck(y2, x2 + 1) && arr[y2][x2 + 1] == 0) {
                    q.add(new int[]{y1, x1 + 1, y2, x2 + 1});
                }
                // 대각선
                if (isCheck(y2 + 1, x2 + 1)
                        && arr[y2][x2 + 1] == 0
                        && arr[y2 + 1][x2 + 1] == 0
                        && arr[y2 + 1][x2] == 0) {
                    q.add(new int[]{y1, x1 + 1, y2 + 1, x2 + 1});
                }
            } else if (x1 == x2 && y1 + 1 == y2) {
                //아래
                if (isCheck(y2 + 1, x2) && arr[y2 + 1][x2] == 0) {
                    q.add(new int[]{y1 + 1, x1, y2 + 1, x2});
                }
                if (isCheck(y2 + 1, x2 + 1)
                        && arr[y2][x2 + 1] == 0
                        && arr[y2 + 1][x2 + 1] == 0
                        && arr[y2 + 1][x2] == 0) {
                    q.add(new int[]{y1 + 1, x1, y2 + 1, x2 + 1});
                }
            } else {
                if (isCheck(y2, x2 + 1) && arr[y2][x2 + 1] == 0) {
                    q.add(new int[]{y1 + 1, x1 + 1, y2, x2 + 1});
                }
                if (isCheck(y2 + 1, x2) && arr[y2 + 1][x2] == 0) {
                    q.add(new int[]{y1 + 1, x1 + 1, y2 + 1, x2});
                }
                if (isCheck(y2 + 1, x2 + 1)
                        && arr[y2][x2 + 1] == 0
                        && arr[y2 + 1][x2 + 1] == 0
                        && arr[y2 + 1][x2] == 0) {
                    q.add(new int[]{y1 + 1, x1 + 1, y2 + 1, x2 + 1});
                }
            }
        }
    }

    private static boolean isCheck(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < n;
    }
}
