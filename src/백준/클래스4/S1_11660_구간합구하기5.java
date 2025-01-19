package 백준.클래스4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * n*n 표
 */
public class S1_11660_구간합구하기5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] repo = br.readLine().split(" ");

        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(repo[0]);
        int m = Integer.parseInt(repo[1]);
        int[][] mem = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            String[] temp = br.readLine().split(" ");

            for (int j = 1; j <= n; j++) {
                mem[i][j] = mem[i][j - 1] + mem[i - 1][j] - mem[i - 1][j - 1] + Integer.parseInt(temp[j - 1]);
            }
        }

        for (int i = 0; i < m; i++) {
            String[] temp = br.readLine().split(" ");

            int y1 = Integer.parseInt(temp[0]);
            int x1 = Integer.parseInt(temp[1]);
            int y2 = Integer.parseInt(temp[2]);
            int x2 = Integer.parseInt(temp[3]);

            sb.append(mem[y2][x2] - mem[y1 - 1][x2] - mem[y2][x1 - 1] + mem[y1 - 1][x1 - 1]).append("\n");
        }

        System.out.println(sb);
    }
}
