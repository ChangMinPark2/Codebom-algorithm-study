package 백준.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class S1_11057 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] mem = new int[n + 1][10];

        for (int i = 0; i < 10; i++) {
            mem[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                for (int z = j; z < 10; z++) {
                    mem[i][j] += mem[i - 1][z] % 10007;
                }
            }
        }

        int sum = 0;

        for (int i = 0; i < 10; i++) {
            sum += mem[n][i];
        }

        System.out.println(sum % 10007);
    }
}
