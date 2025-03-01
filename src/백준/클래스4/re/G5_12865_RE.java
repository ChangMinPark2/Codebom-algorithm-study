package 백준.클래스4.re;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class G5_12865_RE {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        int n = Integer.parseInt(temp[0]);
        int k = Integer.parseInt(temp[1]);

        int[] w = new int[n + 1];
        int[] v = new int[n + 1];
        int[][] mem = new int[n + 1][k + 1];

        for (int i = 1; i <= n; i++) {
            temp = br.readLine().split(" ");
            w[i] = Integer.parseInt(temp[0]);
            v[i] = Integer.parseInt(temp[1]);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                if (w[i] > j) {
                    mem[i][j] = mem[i - 1][j];
                } else {
                    mem[i][j] = Math.max(mem[i - 1][j], mem[i - 1][j - w[i]] + v[i]);
                }
            }
        }

        System.out.println(mem[n][k]);
    }
}
