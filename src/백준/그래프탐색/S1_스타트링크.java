package 백준.그래프탐색;

import java.io.*;
import java.util.*;

public class S1_스타트링크 {
    static int max, current, target, up, down, count = 0;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        max = Integer.parseInt(input[0]);
        current = Integer.parseInt(input[1]);
        target = Integer.parseInt(input[2]);
        up = Integer.parseInt(input[3]);
        down = Integer.parseInt(input[4]);
        visited = new boolean[max + 1];
        bfs();

        if (!visited[target]) {
            System.out.println("use the stairs");
            return;
        }
        System.out.println(count);
    }

    static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {current, 0});
        visited[current] = true;

        while (!q.isEmpty()) {
            int[] temp = q.remove();
            int floor = temp[0];
            int fCount = temp[1];

            if (floor == target) {
                count = fCount;
            }

            if (floor + up <= max && !visited[floor + up]) {
                q.add(new int[] {floor + up, fCount + 1});
                visited[floor + up] = true;
            }

            if (floor - down > 0 && !visited[floor - down]) {
                q.add(new int[] {floor - down, fCount + 1});
                visited[floor - down] = true;
            }
        }
    }
}
