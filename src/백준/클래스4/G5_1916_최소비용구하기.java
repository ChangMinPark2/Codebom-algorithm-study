package 백준.클래스4;

import java.util.*;
import java.io.*;

/**
 * N <= 1000, M<= 100,000
 */
public class G5_1916_최소비용구하기 {
    static int n, m;
    static List<List<Bus>> buses = new ArrayList<>();
    static boolean[]visited;
    static int[] dist;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        dist = new int[n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            buses.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            String[] repo = br.readLine().split(" ");
            int a = Integer.parseInt(repo[0]);
            int b = Integer.parseInt(repo[1]);
            int c = Integer.parseInt(repo[2]);

            buses.get(a).add(new Bus(b, c));
        }

        String[] repo = br.readLine().split(" ");
        int start = Integer.parseInt(repo[0]);
        int end = Integer.parseInt(repo[1]);

        dijk(start);
        System.out.println(dist[end]);
    }

    private static void dijk(int start) {
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Bus> pq = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);

        pq.add(new Bus(start, 0));
        dist[start] = 0;
        
        while (!pq.isEmpty()) {
            Bus now = pq.remove();

            if (!visited[now.number]) {
                visited[now.number] = true;

                for (Bus next : buses.get(now.number)) {
                    if (dist[next.number] > dist[now.number] + next.weight) {
                        dist[next.number] = dist[now.number] + next.weight;
                        pq.add(new Bus(next.number, dist[next.number]));
                    }
                }
            }
        }

    }

    static class Bus {
        int number;
        int weight;

        public Bus(int number, int weight) {
            this.number = number;
            this.weight = weight;
        }
    }
}
