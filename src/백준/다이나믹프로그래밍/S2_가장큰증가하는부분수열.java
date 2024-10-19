package 백준.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class S2_가장큰증가하는부분수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] repo = br.readLine().split(" ");

        int[] arr = new int[n];
        int[] mem = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(repo[i]);
        }

        mem[0] = arr[0];
        int answer = mem[0];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    mem[i] = Math.max(mem[i],mem[j]);
                }
            }
            mem[i] += arr[i];
            answer = Math.max(answer, mem[i]);
        }
        System.out.println(Arrays.toString(mem));
        System.out.println(answer);
    }
}
