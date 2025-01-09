package 백준.클래스3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class G5_16928_뱀과사다리게임 {
    static boolean[] visited = new boolean[101];
    static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        int n = Integer.parseInt(temp[0]);
        int m = Integer.parseInt(temp[1]);

        for (int i = 0; i < n + m; i++) {
            String[] repo = br.readLine().split(" ");
            map.put(Integer.parseInt(repo[0]), Integer.parseInt(repo[1]));
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[] {1, 0});
        visited[1] = true;

        while (!q.isEmpty()) {
            int[] temp = q.remove();
            int stand = temp[0];
            int score = temp[1];

            if (stand == 100) {
                return score;
            }

            for (int i = 1; i <= 6; i++) {
                int next = stand + i;

                if (next > 100) continue;

                if (map.containsKey(next)) {
                    next = map.get(next);
                }

                if (!visited[next]) {
                    visited[next] = true;
                    q.add(new int[] {next, score + 1});
                }
            }
        }

        return -1;
    }

}
