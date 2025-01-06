package 백준.클래스3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * n: 1000
 * 1: 1
 * 2: 3
 * 3: 5
 * 4: 11
 */

public class S3_11727_2xn타일링2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] mem = new long[1001];

        mem[1] = 1;
        mem[2] = 3;
        mem[3] = 5;
        mem[4] = 11;

        for (int i = 5; i <= 1000; i++) {
            mem[i] = (mem[i - 1] + mem[i - 2] * 2) % 10007;
        }

        System.out.println(mem[n]);
    }
}
