package 백준_Re.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S3_1788 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()) + 1000000;
        int[] mem = new int[2000001];

        mem[1000000] = 0;
        mem[1000001] = 1;
        int stand = 1000000000;


        if (n <= 1000000 - 1) {
            for (int i = 1000000-1; i >= n; i--) {
                mem[i] = (mem[i + 2] - mem[i + 1]) % stand;
            }
        } else {
            for (int i = 1000002; i <= n; i++) {
                mem[i] = (mem[i - 1] + mem[i - 2]) % stand;
            }
        }

        if (mem[n] == 0) {
            System.out.println(0);
        } else if (mem[n] > 0) {
            System.out.println(1);
        } else System.out.println(-1);

        System.out.println(Math.abs(mem[n]));
    }
}
