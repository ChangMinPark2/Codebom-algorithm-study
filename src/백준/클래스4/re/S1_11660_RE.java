package 백준.클래스4.re;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S1_11660_RE {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] repo = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(repo[0]);
        int m = Integer.parseInt(repo[1]);

        int[][] arr = new int[n + 1][n + 1];
        int[][] mem = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            repo = br.readLine().split(" ");

            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(repo[j - 1]);
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                mem[i][j] = mem[i - 1][j] + mem[i][j - 1] - mem[i - 1][j - 1] + arr[i][j];
            }
        }

        for (int i = 0; i < m; i++) {
            repo = br.readLine().split(" ");

            int y1 = Integer.parseInt(repo[0]);
            int x1 = Integer.parseInt(repo[1]);
            int y2 = Integer.parseInt(repo[2]);
            int x2 = Integer.parseInt(repo[3]);

            sb.append(mem[y2][x2] - mem[y1 - 1][x2] - mem[y2][x1 - 1] + mem[y1 - 1][x1 - 1]).append("\n");
        }

        System.out.println(sb);
    }
}
