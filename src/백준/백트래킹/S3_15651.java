package 백준.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 입력값 N과 M 2개가 하나의 문자열
 * N까지, M개 만큼
 */
public class S3_15651 {
    static int[] map;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] repo = br.readLine().split(" ");
        int n = Integer.parseInt(repo[0]);
        int m = Integer.parseInt(repo[1]);
        visited = new boolean[n];
        map = new int[m];
        dfs(n, m, 0);
        System.out.println(sb);
    }

    static void dfs(int n, int m, int depth) {
        if (depth == m) {
            for (int i : map) {
                sb.append(i).append(" ");
            }
            sb.append('\n');
            return;
        }

        for (int i = 0; i < n; i++) {
            visited[i] = true;
            map[depth] = i + 1;
            dfs(n, m, depth + 1);
            visited[i] = false;
        }
    }
}
