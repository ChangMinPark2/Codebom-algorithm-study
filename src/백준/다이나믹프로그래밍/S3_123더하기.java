package 백준.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * n이 주어졌을 때, 1, 2, 3의 합으로 나타내는 방법의 수를 구하기.
 * n-1, n-2, n-3 더한게 n임. -> 규칙을 알아내야함..
 */
public class S3_123더하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] mem = new int[11];

        mem[1] = 1;
        mem[2] = 2;
        mem[3] = 4;

        for (int i = 4; i <= 10; i++) {
            mem[i] = mem[i - 1] + mem[i - 2] + mem[i - 3];
        }

        for (int i = 0; i < n; i++) {
            int t = Integer.parseInt(br.readLine());
            System.out.println(mem[t]);
        }

    }
}
