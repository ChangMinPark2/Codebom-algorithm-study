package 백준_Re.DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class S2_1260 {
    static StringBuilder sb = new StringBuilder();
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] repo = br.readLine().split(" ");
        n = Integer.parseInt(repo[0]); // 정점의 개수
        m = Integer.parseInt(repo[1]); // 간선의 개수
        int start = Integer.parseInt(repo[2]); // 시작 번호

        int[][] graph = new int[n + 1][n + 1];
        boolean[] visited = new boolean[n + 1];

        //그래프
        for (int i = 0; i < m; i++) {
            String[] temp = br.readLine().split(" ");
            int a = Integer.parseInt(temp[0]);
            int b = Integer.parseInt(temp[1]);

            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        dfs(graph, visited, start);
        sb.append("\n");
        visited = new boolean[n + 1];
        bfs(graph, visited, start);
        System.out.println(sb);

    }

    static void dfs(int[][] graph, boolean[] visited, int start) {
        visited[start] = true;
        sb.append(start).append(" ");

        for (int i = 1; i < graph.length; i++) {
            if (graph[start][i] == 1 && !visited[i]) {
                dfs(graph, visited, i);
            }
        }
    }

    static void bfs(int[][] graph, boolean[] visited, int start) {
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.add(start);

        while (!q.isEmpty()) {
            int temp = q.remove();
            sb.append(temp).append(" ");

            for (int i = 1; i < graph.length; i++) {
                if (graph[temp][i] == 1 && !visited[i]) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}
