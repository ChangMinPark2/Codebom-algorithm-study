package 백준.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class G4_숨바꼭질4 {
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;
    static StringBuilder one = new StringBuilder();
    static StringBuilder two = new StringBuilder();
    static StringBuilder three = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] repo = br.readLine().split(" ");

        int start = Integer.parseInt(repo[0]);
        int dep = Integer.parseInt(repo[1]);
        visited = new boolean[100001];

        one.append(start + " ");
        two.append(start + " ");
        three.append(start + " ");

        bfs(start, dep);
        System.out.println(min);
    }

    static void bfs(int start, int dep) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {start, 0});
        visited[start] = true;

        while (!q.isEmpty()) {
            int[] temp = q.remove();

            int now = temp[0];
            int time = temp[1];

            if (now == dep)  {
                min = Math.min(min, time);
            }

            if (now * 2 <= 100000 && !visited[now * 2]) {
                q.add(new int[] {now * 2, time});
                visited[now * 2] = true;
            }

            if (now - 1 >= 0 && !visited[now - 1]) {
                q.add(new int[] {now - 1, time + 1});
                visited[now - 1] = true;
            }

            if (now + 1 <= 100000 && !visited[now + 1]) {
                q.add(new int[] {now + 1, time + 1});
                visited[now + 1] = true;
            }
        }
    }
}
