package 백준_Re.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 0 = 0;
 * mem0 = arr0;
 * mem1 = math.max arr1, mem0 + arr1; 이게 맞음?
 *
 *
 */
public class S2_1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] repo = br.readLine().split(" ");
        int[] arr = Arrays.stream(repo)
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] mem = new int[n];

        mem[0] = arr[0];

        int answer = mem[0];

        for (int i = 1; i < n; i++) {
            mem[i] = Math.max(arr[i], mem[i - 1] + arr[i]);
            answer = Math.max(answer, mem[i]);
        }

        System.out.println(answer);
    }
}
