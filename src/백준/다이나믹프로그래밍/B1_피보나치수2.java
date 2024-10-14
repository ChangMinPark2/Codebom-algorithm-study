package 백준.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B1_피보나치수2 {

    static int[] mem;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        mem = new int[n + 1];

        mem[0] = 0;
        mem[1] = 1;

        for (int i = 2; i <= n; i++) {
            mem[i] = mem[i - 1] + mem[i - 2];
        }
        System.out.println(mem[n]);
    }
}
