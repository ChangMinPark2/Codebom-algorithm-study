package 백준.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 0 -> 1만 가능
 * 9 -> 8만 가능
 */
public class S1_쉬운계단수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[][] mem = new long[n + 1][10];

        int stand = 1000000000;

        for (int i = 1; i < 10; i++) {
            mem[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {

            for (int j = 0; j < 10; j++) {
                if (j == 0) {
                    mem[i][0] = mem[i - 1][1] % stand;
                } else if (j == 9) {
                    mem[i][9] = mem[i - 1][8] % stand;
                } else {
                    mem[i][j] = (mem[i - 1][j - 1] + mem[i - 1][j + 1]) % stand;
                }
            }
        }

        long answer = 0;

        for (int i = 0; i < 10; i++) {
            answer += mem[n][i];
        }

        System.out.println(answer % stand);
    }
}
