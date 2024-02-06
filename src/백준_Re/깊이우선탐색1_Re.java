package 백준_Re;

import java.util.*;
import java.io.*;
public class 깊이우선탐색1_Re {
    static int vertex, edge, start, count = 1;
    static List<List<Integer>> graph = new ArrayList<>();

    static int[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] repo = br.readLine().split(" ");

        vertex = Integer.parseInt(repo[0]);
        edge = Integer.parseInt(repo[1]);
        start = Integer.parseInt(repo[2]);

        visited = new int[vertex + 1];

        for (int i = 0; i <= vertex; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edge; i++) {
            repo = br.readLine().split(" ");
            int a = Integer.parseInt(repo[0]);
            int b = Integer.parseInt(repo[1]);

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (int i = 1; i <= vertex; i++) {
            Collections.sort(graph.get(i));
        }
        dfs(start);

        for (int i = 1; i <= vertex; i++) {
            System.out.println(visited[i]);
        }

    }

    static void dfs(int start) {
        visited[start] = count++;

        for (int i = 0; i < graph.get(start).size(); i++) {
            int next = graph.get(start).get(i);
            if (visited[next] == 0) {
                dfs(next);
            }
        }
    }
}
