package 백준.클래스3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * n이 1000, 이 n* n-1 /2
 * m이 크므로 인접리스트로.
 * dfs의 경우, 방문하지 않았다면 탐색 시작하며 ++
 */
public class S2_11724_연결요소의개수 {
    static int n, m;
    static boolean[] visited;
    static List<List<Integer>> list = new ArrayList<>();
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] repo = br.readLine().split(" ");
        n = Integer.parseInt(repo[0]);
        m = Integer.parseInt(repo[1]);
        visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            String[] temp = br.readLine().split(" ");
            int a = Integer.parseInt(temp[0]);
            int b = Integer.parseInt(temp[1]);

            list.get(a).add(b);
            list.get(b).add(a);
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                dfs(i);
                answer++;
            }
        }

        System.out.println(answer);
    }

    private static void dfs(int start) {
        visited[start] = true;

        for (int i = 0; i < list.get(start).size(); i++) {
            if (!visited[list.get(start).get(i)]) {
                dfs(list.get(start).get(i));
            }
        }
    }

    private static void bfs(int start) {
        visited[start] = true;
        Deque<Integer> q = new ArrayDeque<>();
        q.add(start);

        while (!q.isEmpty()) {
            int next = q.remove();

            for (int i = 0; i < list.get(next).size(); i++) {
                if (!visited[list.get(next).get(i)]) {
                    visited[list.get(next).get(i)] = true;

                    q.add(list.get(next).get(i));
                }
            }
        }
    }
}
