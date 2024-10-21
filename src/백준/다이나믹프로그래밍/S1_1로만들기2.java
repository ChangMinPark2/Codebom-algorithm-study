package 백준.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S1_1로만들기2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] mem = new int[n + 1];
        int[] arr = new int[n + 1];

        mem[1] = 0;

        for (int i = 2; i <= n; i++) {
            mem[i] = mem[i - 1] + 1;
            arr[i] = i - 1;

            if (i % 3 == 0 && mem[i] > mem[i / 3] + 1) {
                mem[i] = mem[i / 3] + 1;
                arr[i] = i / 3;
            }

            if (i % 2 == 0 && mem[i] > mem[i / 2] + 1) {
                mem[i] = mem[i / 2] + 1;
                arr[i] = i / 2;
            }
        }
        StringBuilder sb = new StringBuilder();
        System.out.println(mem[n]);

        while(n > 0) {
            sb.append(n).append(" ");
            n = arr[n];
        }

        System.out.println(sb);
    }
}
