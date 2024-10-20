package 백준.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 항의 최소 개수를 구하기.
 * 1 -> 1
 * 2 -> 2
 * 3 -> 3
 * 4 -> 1
 * 5 -> 2
 * 6 -> 3
 * 7 -> 4
 * 8 -> 2
 * 9 -> 1
 *
 */
public class S2_1699 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] mem = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            mem[i] = i;

            for (int j = 1; j * j <= i; j++) {
                if (mem[i] > mem[i - j * j] + 1) {
                    mem[i] = mem[i - j * j] + 1;
                }
            }
        }

        System.out.println(mem[n]);
    }
}
