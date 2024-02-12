package 백준.트리;
import java.util.*;
import java.io.*;

public class S2_촌수계산 {
    static int v, e, start, target, count;
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        v = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        start = Integer.parseInt(input[0]);
        target = Integer.parseInt(input[1]);
        e = Integer.parseInt(br.readLine());

        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }
        visited = new boolean[v + 1];

        for (int i = 0; i < e; i++) {
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        bfs();

        if (!visited[target]) {
            System.out.println(-1);
            return;
        }
        System.out.println(count);
    }

    static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start, 0});

        while (!q.isEmpty()) {
            int[] temp = q.remove();
            int vertex = temp[0];
            int depth = temp[1];

            visited[vertex] = true;

            if (vertex == target) {
                count = depth;
                return;
            }

            for (int i : graph.get(vertex)) {
                if (!visited[i]) {
                    q.add(new int[]{i, depth + 1});
                }
            }
        }
    }
}
