package 백준.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S3_15652 {
    static int[] map;
    static boolean[] visited;
    static int[] check;
    static StringBuilder sb = new StringBuilder();
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] repo = br.readLine().split(" ");
        int n = Integer.parseInt(repo[0]);// 4
        int m = Integer.parseInt(repo[1]);// 2
        map = new int[m];
        visited = new boolean[n];
        check = new int[n];

        dfs(n, m, 0, 1);
        System.out.println(sb);
    }

    static void dfs(int n, int m, int depth, int start) {
        if (m == depth) {
            for (int i : map) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i <= n; i++) {
            map[depth] = i;
            dfs(n, m, depth + 1, i);
        }
    }
}
