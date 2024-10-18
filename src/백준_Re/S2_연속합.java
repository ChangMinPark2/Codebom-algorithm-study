package 백준_Re;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S2_연속합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] mem = new int[100000];
        int[] arr = new int[n];
        String[] repo = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(repo[i]);
        }

        mem[0] = arr[0];
        int answer = arr[0];

        for (int i = 1; i < n; i++) {
            mem[i] = Math.max(arr[i], mem[i - 1] + arr[i]);

            answer = Math.max(answer, mem[i]);
        }
        System.out.println(answer);
    }
}
