package 백준.클래스4.re;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class G5_1916_RE {
    private static final int INF = 1000000000;
    static int n, m;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        arr = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) continue;
                arr[i][j] = INF;
            }
        }

        for (int i = 0; i < m; i++) {
            String[] temp = br.readLine().split(" ");

            int from = Integer.parseInt(temp[0]);
            int to = Integer.parseInt(temp[1]);
            int cost = Integer.parseInt(temp[2]);

            arr[from][to] = Math.min(arr[from][to], cost);
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                }
            }
        }

        String[] repo = br.readLine().split(" ");
        int start = Integer.parseInt(repo[0]);
        int end = Integer.parseInt(repo[1]);

        System.out.println(arr[start][end]);
    }
}
