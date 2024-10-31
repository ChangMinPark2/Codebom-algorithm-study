package 백준.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S1_11052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[1001];
        int[] mem = new int[1001];

        String[] repo = br.readLine().split(" ");

        for (int i = 1; i <= repo.length; i++) {
            arr[i] = Integer.parseInt(repo[i - 1]);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                mem[i] = Math.max(mem[i], mem[i - j] + arr[j]);
            }
        }
        System.out.println(mem[n]);
    }
}
