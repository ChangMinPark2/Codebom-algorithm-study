package 백준.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class S3_이친수 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long [] mem = new long[91];

        mem[1] = 1;
        mem[2] = 1;

        for (int i = 3; i <= n; i++) {
            mem[i] = mem[i - 1] + mem[i - 2];
        }

        System.out.println(mem[n]);
    }
}
