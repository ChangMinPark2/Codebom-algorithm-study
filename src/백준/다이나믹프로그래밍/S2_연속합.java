package 백준.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S2_연속합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int[] mem = new int[n];

        String[] repo = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(repo[i]);
        }

        mem[0] = arr[0];
        int max = arr[0];

        for (int i = 1; i < n; i++) {
            mem[i] = Math.max(arr[i], mem[i - 1] + arr[i]);

            max = Math.max(max, mem[i]);
        }

        System.out.println(max);
    }
}
