package 백준_Re.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * n -> 1일 때, 크기: 2 -> 1개
 * n -> 2일 때, 크기: 4 -> 2개
 * n -> 3일 때, 크기: 6 -> 3개
 * n -> 4일 때, 크기: 8 -> 5개
 * 여기까지의 점화식 -> n-1 + n-2
 */
public class S3_11726 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] mem = new int[1001];

        mem[1] = 1;
        mem[2] = 2;

        for (int i = 3; i <= 1000; i++) {
            mem[i] = (mem[i - 1] + mem[i - 2]) % 10007;
        }

        System.out.println(mem[n]);
    }
}
