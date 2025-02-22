package 백준.클래스4.re;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S1_9465_RE {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            String[] up = br.readLine().split(" ");
            String[] down = br.readLine().split(" ");

            int[][] arr = new int[2][n + 1];
            int[][] mem = new int[2][n + 1];

            for (int j = 1; j <= n; j++) {
                arr[0][j] = Integer.parseInt(up[j - 1]);
                arr[1][j] = Integer.parseInt(down[j - 1]);
            }

            mem[0][1] = arr[0][1];
            mem[1][1] = arr[1][1];

            for (int j = 2; j <= n; j++) {
                mem[0][j] = Math.max(mem[1][j - 1], mem[1][j - 2]) + arr[0][j];
                mem[1][j] = Math.max(mem[0][j - 1], mem[0][j - 2]) + arr[1][j];
            }

            sb.append(Math.max(mem[0][n], mem[1][n])).append("\n");
        }

        System.out.println(sb);
    }
}
