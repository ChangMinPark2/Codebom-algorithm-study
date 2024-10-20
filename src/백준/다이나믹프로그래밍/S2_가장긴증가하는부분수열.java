package 백준.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S2_가장긴증가하는부분수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] repo = br.readLine().split(" ");

        int[] arr = new int[n];
        int[] mem = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(repo[i]);
            mem[i] = 1;
        }

        int answer = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    mem[i] = Math.max(mem[i], mem[j] + 1);
                }
            }
            answer = Math.max(mem[i], answer);
        }
        System.out.println(answer);
    }
}
