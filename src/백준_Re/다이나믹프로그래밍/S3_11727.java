package 백준_Re.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * n : 1 -> 1개
 * n : 2 -> 3개
 * n : 3 -> 5개
 * n : 4 -> 9개
 */
public class S3_11727 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] mem = new int[1001];

        mem[0] = 1;
        mem[1] = 1;
        mem[2] = 3;

        for (int i = 3; i < 1001; i++) {
            mem[i] = (mem[i - 1] + mem[i - 2] * 2) % 10007;
        }

        System.out.println(mem[n]);
    }
}
