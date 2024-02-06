package 백준_Re;

import java.util.*;
import java.io.*;
public class 깊이우선탐색1_Re {
    static int vertex, edge, start, count = 1;
    static List<Integer>[] graph;

    static int[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] repo = br.readLine().split(" ");

        vertex = Integer.parseInt(repo[0]);
        edge = Integer.parseInt(repo[1]);
        start = Integer.parseInt(repo[2]);
        graph = new ArrayList[vertex + 1];
        visited = new int[vertex + 1];

        for (int i = 1; i <= vertex; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < edge; i++) {
            repo = br.readLine().split(" ");
            int a = Integer.parseInt(repo[0]);
            int b = Integer.parseInt(repo[1]);

            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i = 1; i <= vertex; i++) {
            Collections.sort(graph[i]);
        }
        dfs(start);

        for (int i = 1; i <= vertex; i++) {
            System.out.println(visited[i]);
        }

    }

    static void dfs(int start) {
        visited[start] = count++;

        for (int i = 0; i < graph[start].size(); i++) {
            int next = graph[start].get(i);
            if (visited[next] == 0) {
                dfs(next);
            }
        }
    }
}
