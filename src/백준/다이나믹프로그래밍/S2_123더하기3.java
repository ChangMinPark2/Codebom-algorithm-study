package 백준.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S2_123더하기3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] mem = new long[1000001];
        mem[1] = 1;
        mem[2] = 2;
        mem[3] = 4;
        mem[4] = 7;

        for (int i = 5; i <= 1000000; i++) {
            mem[i] = (mem[i - 1] + mem[i - 2] + mem[i - 3]) % 1000000009;
        }

        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(br.readLine());
            System.out.println(mem[temp]);
        }
    }
}
