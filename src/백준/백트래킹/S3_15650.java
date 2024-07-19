package 백준.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S3_15650 {
    static boolean[] visited;
    static int[] arr;
    static StringBuilder sb;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] repo = br.readLine().split(" ");
        int n = Integer.parseInt(repo[0]);
        int m = Integer.parseInt(repo[1]);

        visited = new boolean[n];
        arr = new int[m];
        sb = new StringBuilder();

        dfs(n, m, 1, 0);
        System.out.println(sb);
    }

    static void dfs(int n, int m, int start, int depth) {
        if (depth == m) {
            for (int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i <= n; i++) {
            if (!visited[i - 1]) {
                visited[i - 1] = true;
                arr[depth] = i;
                dfs(n, m, i + 1, depth + 1);
                visited[i - 1] = false;
            }
        }
    }
}
