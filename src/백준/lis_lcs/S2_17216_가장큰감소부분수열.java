package 백준.lis_lcs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class S2_17216_가장큰감소부분수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] mem = new int[n];
        int answer = -1;

        for (int i = 0; i < n; i++) {
            mem[i] = arr[i];

            for (int j = 0; j < i; j++) {
                if (arr[i] < arr[j]) {
                    mem[i] = Math.max(mem[i], mem[j] + arr[i]);
                }
            }

            answer = Math.max(answer, mem[i]);
        }

        System.out.println(answer);
    }
}
