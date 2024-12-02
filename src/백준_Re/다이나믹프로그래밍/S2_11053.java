package 백준_Re.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class S2_11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] repo = br.readLine().split(" ");

        int[] arr = Arrays.stream(repo)
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] mem = new int[n];
        Arrays.fill(mem, 1);

        mem[0] = 1;
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
