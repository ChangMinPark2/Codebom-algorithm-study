package 백준_Re.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1 : 1개
 * 2 : 1 1 2 -> 2개
 * 3 : 1 1 1/ 1 2/ 2 1/ 3 -> 4개
 * 4 : 7개
 */
public class S2_15988 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] mem = new long[1000001];

        mem[1] = 1;
        mem[2] = 2;
        mem[3] = 4;

        for (int i = 4; i < 1000001; i++) {
            mem[i] = (mem[i - 1] + mem[i - 2] + mem[i - 3]) % 1000000009;
        }

        for (int i = 0; i < n; i++) {
            System.out.println(mem[Integer.parseInt(br.readLine())]);
        }
    }
}
