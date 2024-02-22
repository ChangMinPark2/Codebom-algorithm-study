package 백준.그래프탐색;
import java.util.*;
import java.io.*;
public class S2_특정거리도시찾기 {
    static List<List<Integer>> graph = new ArrayList<>();
    static int vertex, edge, distance, start, answer = -1;
    static List<Integer> list = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        vertex = Integer.parseInt(input[0]);
        edge = Integer.parseInt(input[1]);
        distance = Integer.parseInt(input[2]);
        start = Integer.parseInt(input[3]);
        visited = new boolean[vertex + 1];

        for (int i = 0; i <= vertex; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edge; i++) {
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            graph.get(a).add(b);
        }
        bfs();
        if (list.isEmpty()) {
            System.out.println(-1);
            return;
        }
        Collections.sort(list);
        for (int i : list) {
            System.out.println(i);
        }
    }

    static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {start, 0});
        visited[start] = true;

        while (!q.isEmpty()) {
            int[] temp = q.remove();
            int a = temp[0];
            int count = temp[1];

            if (count == distance) {
                list.add(a);
            }

            for (int i = 0; i < graph.get(a).size(); i++) {
                if (!visited[graph.get(a).get(i)]) {
                    q.add(new int[] {graph.get(a).get(i), count + 1});
                    visited[graph.get(a).get(i)] = true;
                }
            }
        }
    }
}
