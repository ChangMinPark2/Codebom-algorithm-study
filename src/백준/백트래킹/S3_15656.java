package 백준.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class S3_15656 {
    static int[] map;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] repo = br.readLine().split(" ");
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();

        int n = Integer.parseInt(repo[0]);
        int m = Integer.parseInt(repo[1]);

        map = new int[m];

        dfs(n, m, arr, 0);
        System.out.println(sb);
    }

    static void dfs(int n, int m, int[] arr, int depth) {
        if (depth == m) {
            for (int i : map) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            map[depth] = arr[i];
            dfs(n, m, arr, depth + 1);
        }
    }
}
