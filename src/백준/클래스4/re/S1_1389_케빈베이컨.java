package 백준.클래스4.re;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class S1_1389_케빈베이컨 {
    private static final int INF = 1_000_000_000;
    static int n, m;
    static int[][] mem;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        n = Integer.parseInt(temp[0]);
        m = Integer.parseInt(temp[1]);

        mem = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) continue;
                mem[i][j] = INF;
            }
        }

        for (int i = 0; i < m; i++) {
            temp = br.readLine().split(" ");
            int a = Integer.parseInt(temp[0]);
            int b = Integer.parseInt(temp[1]);

            mem[a][b] = mem[b][a] = 1;
        }

        floyd();

        int res = INF;
        int index = 0;

        for (int i = 1; i <= n; i++) {
            int sum = 0;

            for (int j = 1; j <= n; j++) {
                sum += mem[i][j];
            }

            if (res > sum) {
                res = sum;
                index = i;
            }
        }

        System.out.println(index);
    }

    private static void floyd() {
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    mem[i][j] = Math.min(mem[i][j], mem[i][k] + mem[k][j]);
                }
            }
        }
    }
}
