package 백준.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class S1_4883 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        int tc = 0;

        while (Integer.parseInt(line = br.readLine()) != 0) {
            tc++;
            int n = Integer.parseInt(line);
            int[][] mem = new int[n][3];

            for (int i = 0; i < n; i++) {
                String[] repo = br.readLine().split(" ");
                mem[i][0] = Integer.parseInt(repo[0]);
                mem[i][1] = Integer.parseInt(repo[1]);
                mem[i][2] = Integer.parseInt(repo[2]);
            }

            for (int i = 1; i < n; i++) {
                if (i == 1) {
                    for (int j = 0; j < 3; j++) {
                        if (j == 0) {
                            mem[i][0] += mem[i - 1][1];
                        } else {
                            mem[i][j] += Math.min(mem[i][j - 1],
                                    Math.min(mem[i - 1][1], mem[i - 1][1] + mem[i - 1][2]));
                        }
                    }
                } else {
                    mem[i][0] += Math.min(mem[i - 1][0], mem[i - 1][1]);
                    mem[i][1] += Math.min(Math.min(mem[i][0], mem[i - 1][0]),
                            Math.min(mem[i - 1][1], mem[i - 1][2]));
                    mem[i][2] += Math.min(mem[i][1], Math.min(mem[i - 1][1], mem[i - 1][2]));
                }
            }
            System.out.println(tc + ". " + mem[n - 1][1]);
        }
    }
}
