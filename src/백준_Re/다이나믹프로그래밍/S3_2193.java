package 백준_Re.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * n : 1 -> 1개
 * n : 2 -> 1개 : 10
 * n : 3 -> 101, 100 2개
 * n : 4 -> 1000, 1001, 1010, 100 -> 3개
 * n : 5 -> 10000, 10100, 10010, 10001, 10101 -> 5개
 * n - 1 + n - 2 ?
 */

public class S3_2193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] mem = new long[91];

        mem[1] = 1;
        mem[2] = 1;

        for (int i = 3; i <= 90; i++) {
            mem[i] = mem[i - 1] + mem[i - 2];
        }

        System.out.println(mem[n]);
    }
}
