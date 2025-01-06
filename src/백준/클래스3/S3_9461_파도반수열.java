package 백준.클래스3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * n: 100
 * 1: 1
 * 2: 1
 * 3: 1
 * 4: 2
 * 5: 2
 * 6: 3
 * 7: 4
 * 8: 5
 * 9: 7
 * 10: 9
 * n - 2 + n - 3
 */
public class S3_9461_파도반수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
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
            sb.append(mem[temp]).append("\n");
        }

        System.out.println(sb);
    }
}
