package 백준_Re.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * mem1 = arr1;
 * mem2 = arr2;
 * mem3 = 3;
 * mem4 = mem[3]+ arr[4]
 * mem5 = mem[4] + arr[5];
 *
 */
public class S2_11055 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] repo = br.readLine().split(" ");

        int[] arr = Arrays.stream(repo)
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] mem = new int[n];

        mem[0] = arr[0];
        int answer = arr[0];

        for (int i = 1; i < n; i++) {
            mem[i] = arr[i];
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    mem[i] = Math.max(mem[i], mem[j] + arr[i]);
                }
            }
            answer = Math.max(answer, mem[i]);
        }

        System.out.println(answer);
    }
}
