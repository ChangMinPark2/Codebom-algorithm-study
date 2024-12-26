package 백준.클래스3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * n: 100, m: 5000
 * 탐색?, 2차원 DP
 * m이 5000이므로, 리스트로
 */

public class S1_1389_케빈베이컨의6단계법칙 {
    static int n, m;
    static List<List<Integer>> list = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] repo = br.readLine().split(" ");
        n = Integer.parseInt(repo[0]);
        m = Integer.parseInt(repo[1]);
        int[] mem = new int[n + 1];

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

        int stand = Integer.MAX_VALUE;

        for (int i = 1; i <= n; i++) {
            int sum = 0;

            for (int j = 1; j <= n; j++) {
                if (i == j) continue;
                visited = new boolean[n + 1];
                sum += bfs(i, j);
            }
            mem[i] = sum;
            stand = Math.min(stand, sum);
        }

        for (int i = 1; i < n; i++) {
            if (mem[i] == stand) {
                System.out.println(i);
                break;
            }
        }
    }

    private static int bfs(int start,int target) {
        Deque<int[]> q = new ArrayDeque<>();
        visited[start] = true;
        q.add(new int[] {start, 0});

        while (!q.isEmpty()) {

            int[] temp = q.remove();
            int a = temp[0];
            int b = temp[1];

            if (a == target) {
                return b;
            }

            for (int i = 0; i < list.get(a).size(); i++) {

                if (!visited[list.get(a).get(i)]) {
                    visited[list.get(a).get(i)] = true;
                    q.add(new int[] {list.get(a).get(i), b + 1});
                }

            }
        }

        return 0;
    }
}
