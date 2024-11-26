package 백준_Re.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * n = n - 2 + n - 3
 */
public class S3_9461 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] mem = new long[101];

        mem[1] = 1;
        mem[2] = 1;
        mem[3] = 1;

        for (int i = 4; i < 101; i++) {
            mem[i] = mem[i - 2] + mem[i - 3];
        }

        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(br.readLine());
            System.out.println(mem[temp]);
        }

    }
}
