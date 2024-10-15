package 백준.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 수 N개가 주어질 때, i번째 부터 J번째 수까지 합을 구하기
 */
public class S3_구간합구하기4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] repo = br.readLine().split(" ");

        int n = Integer.parseInt(repo[0]);
        int m = Integer.parseInt(repo[1]);
        int[] mem = new int[100001];

        String[] repo2 = br.readLine().split(" ");

        for (int i = 1; i <= n; i++) {
            mem[i] = mem[i - 1] + Integer.parseInt(repo2[i - 1]);
        }

        for (int i = 0; i < m; i++) {
            String[] repo3 = br.readLine().split(" ");
            int start = Integer.parseInt(repo3[0]);
            int end = Integer.parseInt(repo3[1]);

            System.out.println(mem[end] - mem[start - 1]);
        }
    }
}
