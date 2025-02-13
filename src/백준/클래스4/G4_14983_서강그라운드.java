package 백준.클래스4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G4_14983_서강그라운드 {
    static int answer = Integer.MIN_VALUE;
    static int n, m, r;
    static List<List<Node>> nodes = new ArrayList<>();
    static int[] item;
    static int[] dist;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        n = Integer.parseInt(temp[0]);
        m = Integer.parseInt(temp[1]);
        r = Integer.parseInt(temp[2]);
        item = new int[n + 1];

        temp = br.readLine().split(" ");

        for (int i = 1; i <= n; i++) {
            item[i] = Integer.parseInt(temp[i - 1]);
        }

        for (int i = 0; i <= n; i++) {
            nodes.add(new ArrayList<>());
        }

        for (int i = 0; i < r; i++) {
            temp = br.readLine().split(" ");
            int a = Integer.parseInt(temp[0]);
            int b = Integer.parseInt(temp[1]);
            int distance = Integer.parseInt(temp[2]);

            nodes.get(a).add(new Node(b, distance));
            nodes.get(b).add(new Node(a, distance));
        }

        dist = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            answer = Math.max(answer, dijkstra(i));
        }

        System.out.println(answer);
    }

    private static int dijkstra(int start) {
        Arrays.fill(dist, Integer.MAX_VALUE);
        visited = new boolean[n + 1];

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node curNode = pq.remove();
            int num = curNode.number;

            if (!visited[num]) {
                visited[num] = true;

                for (Node node : nodes.get(num)) {
                    if (!visited[node.number] && dist[node.number] > dist[num] + node.distance) {
                        dist[node.number] = dist[num] + node.distance;
                        pq.add(new Node(node.number, dist[node.number]));
                    }
                }
            }
        }

        int sum = 0;

        for (int i = 1; i <= n; i++) {
            if (dist[i] <= m) {
                sum += item[i];
            }
        }

        return sum;
    }


    public static class Node implements Comparable<Node>{
        int number;
        int distance;

        public Node(int number, int distance) {
            this.number = number;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return distance - o.distance;
        }
    }
}
