package 백준.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class S3_15655 {
    static int[] map;
    static boolean[] visited;
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
        visited = new boolean[n];

        dfs(n, m, arr, 0, 0);
        System.out.println(sb);
    }

    static void dfs(int n, int m, int[] arr, int depth, int start) {
        if (depth == m) {
            for (int i : map) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = start; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                map[depth] = arr[i];
                dfs(n, m, arr, depth + 1, i);
                visited[i] = false;
            }
        }
    }
}
