package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


/**
 * n m start가 input으로 주어진다.
 * start부터 시작할 때 노드의 방문순서를 출력해라.
 */
public class 깊이우선탐색1 {
    static int N, M, V, count=1;
    static ArrayList<Integer>[] adjList;
    static int[] order;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        V = Integer.parseInt(input[2]);

        adjList = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            adjList[a].add(b);
            adjList[b].add(a);
        }

        // 인접 리스트를 오름차순으로 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(adjList[i]);
        }

        order = new int[N+1];
        dfs(V);

        // 방문한 노드의 순서를 출력
        for (int i = 1; i <= N; i++) {
            System.out.println(order[i]);
        }
    }

    static void dfs(int node) {
        order[node] = count++;
        for (int i = 0; i < adjList[node].size(); i++) {
            int next = adjList[node].get(i);
            if (order[next] == 0) {
                dfs(next);
            }
        }
    }
}
