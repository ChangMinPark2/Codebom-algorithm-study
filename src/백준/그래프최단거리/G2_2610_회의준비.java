package 백준.그래프최단거리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G2_2610_회의준비 {
    private static final int INF = 1000000000;
    static int n, m;
    static int[][] mem;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        mem = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) continue;
                mem[i][j] = INF;
            }
        }

        for (int i = 0; i < m; i++) {
            String[] temp = br.readLine().split(" ");
            int a = Integer.parseInt(temp[0]);
            int b = Integer.parseInt(temp[1]);

            mem[a][b] = mem[b][a] = 1;
        }

        visited = new boolean[n + 1];

        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                list.add(bfs(i));
            }
        }
        StringBuilder sb = new StringBuilder();

        sb.append(list.size()).append("\n");
        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i)).append("\n");
        }

        System.out.println(sb);
    }
    private static int bfs(int start) {
        Deque<Integer> q = new ArrayDeque<>();
        q.add(start);
        visited[start] = true;
        List<Integer> arrList = new ArrayList<>();
        arrList.add(start);

        while (!q.isEmpty()) {
            int temp = q.remove();

            for (int i = 1; i <= n; i++) {
                if (mem[temp][i] != INF && !visited[i]) {
                    visited[i] = true;
                    q.add(i);
                    arrList.add(i);
                }
            }
        }

        floyd();

        int index = -1;
        int answer = INF;

        for (int i = 1; i <= n; i++) {
            if (!arrList.contains(i)) {
                continue;
            }

            int total = 0;

            for (int j = 1; j <= n; j++) {
                if (!arrList.contains(j)) {
                    continue;
                }

                total = Math.max(total, mem[i][j]);
            }

            if (answer > total) {
                answer = total;
                index = i;
            }
        }

        return index;
    }

    private static void floyd() {
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    mem[i][j] = Math.min(mem[i][j], mem[i][k] + mem[k][j]);
                }
            }
        }
    }
}
