package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * n과 m을 주고 방향없는 그래프.
 * 연결된 요소의 개수를 구한다.
 * 1 ~ 노드까지 dfs호출 개수를 리턴하는 문제.
 */
public class 연결요소의개수 {
    static int vertex, edge, count = 0;
    static int[][] graph;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        vertex = Integer.parseInt(input[0]);
        edge = Integer.parseInt(input[1]);
        graph = new int[vertex + 1][vertex + 1];
        visited = new boolean[vertex + 1];

        for (int i = 0; i < edge; i++) {
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            graph[a][b] = graph[b][a] = 1;
        }

        for (int i = 1; i <= vertex; i++) {
            if (!visited[i]) {
                dfs(i);
                count++;
            }
        }

        System.out.println(count);
    }

    static void dfs(int vertex) {
        visited[vertex] = true;

        for (int i = 0; i < graph[0].length; i++) {
            if (!visited[i] && graph[vertex][i] == 1) {
                dfs(i);
            }
        }
    }
}
