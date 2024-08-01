package 백준.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/**
 * N개의 정수로 이루어진 수열이 있을 때 부분수열 중에서 원소를 다 더한 값이 S가 되는 경우의 수.
 *
 */
public class S2_1182 {
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] repo = br.readLine().split(" ");
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int n = Integer.parseInt(repo[0]);
        int s = Integer.parseInt(repo[1]);

        dfs(arr, n, s, 0, 0);
        if (s == 0) count-=1;
        System.out.println(count);
    }

    static void dfs(int[] arr, int n, int s, int sum, int depth) {
        if (n == depth) {
            if (sum == s) {
                count++;
            }
            return;
        }

        dfs(arr, n, s, sum, depth + 1);
        dfs(arr, n, s, sum + arr[depth], depth + 1);
    }
}
