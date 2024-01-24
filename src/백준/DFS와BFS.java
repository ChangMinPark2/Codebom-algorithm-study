package 백준;

import java.io.*;
import java.util.*;

/**
 * 첫 번째 줄에 정점의 개수, 간선의 개수, 탐색을 진행할 숫자.
 */
public class DFS와BFS {

    static boolean[] visited;
    static int[][] graph;
    static int vertex, edge, start;
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] repo = input.split(" ");

        vertex = Integer.parseInt(repo[0]);
        edge = Integer.parseInt(repo[1]);
        start = Integer.parseInt(repo[2]);
        graph = new int[vertex + 1][vertex + 1];

        for (int i = 0; i < edge; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a][b] = graph[b][a] = 1;
        }

        visited = new boolean[vertex + 1];
        dfs(start);
        System.out.println();
        visited = new boolean[vertex + 1];
        bfs(start);
    }

    public static void dfs(int start) {
        visited[start] = true;
        System.out.print(start + " ");

        for (int i = 0; i <= vertex; i++) {
            if (graph[start][i] == 1 && !visited[i])
                dfs(i);
        }
    }

    public static void bfs(int start) {
        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {

            start = q.remove();
            System.out.print(start + " ");

            for (int i = 1; i <= vertex; i++) {
                if (graph[start][i] == 1 && !visited[i]) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}
