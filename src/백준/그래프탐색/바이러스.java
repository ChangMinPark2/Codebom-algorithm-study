package 백준.그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 첫째줄 -> 노드의 수, 둘 째줄 엣지의 수, 이후 blank 로 엣지의 연결정보.
 * start 가 1일때 연결된 수의 count 를 구하는 dfs 문제이다.
 */
public class 바이러스 {
    static int vertex, edge;
    static int[][] graph;
    static boolean[] visited;

    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        vertex = Integer.parseInt(br.readLine());
        edge = Integer.parseInt(br.readLine());
        graph = new int[vertex + 1][vertex + 1];
        visited = new boolean[vertex + 1];

        for (int i = 0; i < edge; i++) {
            String[] repo = br.readLine().split(" ");
            int A = Integer.parseInt(repo[0]);
            int B = Integer.parseInt(repo[1]);

            graph[A][B] = graph[B][A] = 1;
        }

        dfs(1);
        System.out.println(count - 1);
    }

    static void dfs(int start) {
        visited[start] = true;
        count++;
        for (int i = 1; i <= vertex; i++) {
            if (!visited[i] && graph[start][i] == 1) {
                dfs(i);
            }
        }
    }
}
