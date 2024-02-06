package 백준_Re;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class DFS와BFS_re {
    static boolean[] visited;
    static int vertex, edge, start;
    static int[][] graph;

    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] repo = br.readLine().split(" ");

        vertex = Integer.parseInt(repo[0]);
        edge = Integer.parseInt(repo[1]);
        start = Integer.parseInt(repo[2]);
        graph = new int[vertex + 1][vertex + 1];
        visited = new boolean[vertex + 1];

        for (int i = 0; i < edge; i++) {
            String[] repo2 = br.readLine().split(" ");
            int a = Integer.parseInt(repo2[0]);
            int b = Integer.parseInt(repo2[1]);

            graph[a][b] = graph[b][a] = 1;
        }

        dfs(start);
        System.out.println();
        visited = new boolean[vertex + 1];
        bfs(start);
    }

    private static void dfs(int start) {
        visited[start] = true;
        System.out.print(start  + " -> ");
        for (int i = 1; i <= vertex; i++) {
            if (!visited[i] && graph[start][i] == 1) {
                dfs(i);
            }
        }
    }
    private static void bfs(int start) {
        visited[start] = true;
        q.add(start);

        while (!q.isEmpty()) {
            start = q.remove();
            System.out.print(start + " -> ");

            for (int i = 1; i <= vertex; i++) {
                if (!visited[i] && graph[start][i] == 1) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }

}
