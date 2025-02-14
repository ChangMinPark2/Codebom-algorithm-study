package 백준.클래스4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class G3_1238_파티 {
    static int inf = 1_000_000_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");

        int n = Integer.parseInt(temp[0]);
        int m = Integer.parseInt(temp[1]);
        int x = Integer.parseInt(temp[2]);

        int[][] mem = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) continue;
                mem[i][j] = inf;
            }
        }

        for (int i = 0; i < m; i++) {
            temp = br.readLine().split(" ");
            int a = Integer.parseInt(temp[0]);
            int b = Integer.parseInt(temp[1]);
            int cost = Integer.parseInt(temp[2]);

            mem[a][b] = cost;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    mem[i][j] = Math.min(mem[i][j], mem[i][k] + mem[k][j]);
                }
            }
        }

        int answer = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            answer = Math.max(mem[i][x] + mem[x][i], answer);
        }

        for (int [] arr: mem) {
            System.out.println(Arrays.toString(arr));
        }

        System.out.println(answer);
    }
}
