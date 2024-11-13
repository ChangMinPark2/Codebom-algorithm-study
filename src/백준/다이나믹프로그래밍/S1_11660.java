package 백준.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S1_11660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] repo = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(repo[0]);
        int te = Integer.parseInt(repo[1]);

        int[][] mem = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            String[] repos = br.readLine().split(" ");
           for (int j = 1; j <= n; j++) {
               mem[i][j] = mem[i][j - 1] + Integer.parseInt(repos[j - 1]);
           }
        }

        for (int i = 0; i < te; i++) {
            int sum = 0;
            String[] temp = br.readLine().split(" ");

            int x1 = Integer.parseInt(temp[0]);
            int y1 = Integer.parseInt(temp[1]);
            int x2 = Integer.parseInt(temp[2]);
            int y2 = Integer.parseInt(temp[3]);

            for (int j = x1; j <= x2; j++) {
                sum = sum + (mem[j][y2] - mem[j][y1 - 1]);
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
}
