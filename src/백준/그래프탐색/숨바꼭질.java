package 백준.그래프탐색;

import java.util.*;
import java.io.*;

/**
 * BFS -> result -1, result +1; result * 2 를 큐에 넣는다.
 * depth가 target일때 return;
 */
public class 숨바꼭질 {
    static int now, target;
    static boolean[] visited = new boolean[100001]; // 방문 여부를 체크할 배열. 위치가 10만까지 가능하므로.
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        now = Integer.parseInt(input[0]);
        target = Integer.parseInt(input[1]);

        System.out.println(bfs(now));
    }

    static int bfs(int now) {
        q.add(new int[]{now, 0});
        visited[now] = true;

        while (!q.isEmpty()) {
            int[] standard = q.poll();

            if (standard[0] == target) {
                return standard[1];
            }

            Check(standard[0] - 1, standard[1]);
            Check(standard[0] + 1, standard[1]);
            Check(standard[0] * 2, standard[1]);
        }
        return 0;
    }
    private static void Check(int x, int y) {
        if (x >= 0 && x <= 100000 && !visited[x]) {
            q.add(new int[] {x, y + 1});
            visited[x] = true;
        }
    }
}


