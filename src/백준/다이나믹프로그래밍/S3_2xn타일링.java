package 백준.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S3_2xn타일링 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] mem = new int[1001];

        mem[1] = 1;
        mem[2] = 2;

        for (int i = 3; i <= n; i++) {
            mem[i] = mem[i - 1] + mem[i - 2] % 10007;
        }

        System.out.println(mem[n]);
    }
}
