package 백준.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class S3_15654 {
    static boolean[] visited;
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

        visited = new boolean[n];
        map = new int[m];

        dfs(n, m, 0, arr);
        System.out.println(sb);
    }

    static void dfs(int n, int m, int depth, int[] arr) {

        if (depth == m) {
            for (int i : map) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                map[depth] = arr[i];
                dfs(n, m, depth + 1, arr);
                visited[i] = false;
            }
        }
    }
}
