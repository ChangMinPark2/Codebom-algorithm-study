package 백준_Re.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * n을 1, 2, 3의 합으로 나타내는 방법의 수를 구하기
 * 1 -> 1개
 * 2 -> 1 1, 1 2 (2개)
 * 3 -> 1 1 1, 1 2, 2 1, 3 -> 4개
 * 4 -> 7개
 * 5 -> 13개
 * 1 1 1 1 1
 * 1 1 1 2
 * 1 1 2 1
 * 1 2 1 1
 * 2 1 1 1
 * 3 1 1
 * 1 3 1
 * 1 1 3
 * 2 2 1
 * 2 1 2
 * 1 2 2
 * 2 3
 * 3 2
 * 점화식 -> (n-1 + n-2 + n-3)
 */
public class S3_9095 {
    public static void main(String[] args) throws IOException {
        int[] mem = new int[12];

        mem[1] = 1;
        mem[2] = 2;
        mem[3] = 4;

        for (int i = 4; i <= 11; i++) {
            mem[i] = mem[i - 1] + mem[i - 2] + mem[i - 3];
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(br.readLine());
            System.out.println(mem[temp]);
        }
    }
}
