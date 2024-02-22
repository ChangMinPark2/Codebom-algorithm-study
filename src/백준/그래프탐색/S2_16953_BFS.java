package 백준.그래프탐색;
import java.util.*;
import java.io.*;

/**
 * [0] -> [1] 로 바꿀 수 있는 최단거리 구하기
 * 2를 곱하거나, 1을 이어 붙이거나.
 * 방문하지 않았고, 곱하거나 이어 붙혔을 때 [1]보다 크지 않아야 한다.
 */
public class S2_16953_BFS {
    static long A, B;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        A = Long.parseLong(input[0]);
        B = Long.parseLong(input[1]);
        System.out.println(bfs());
    }

    static long bfs() {
        Queue<long[]> q = new LinkedList<>();
        q.add(new long[] {A, 1});

        while (!q.isEmpty()) {
            long[] temp = q.remove();
            long current = temp[0];
            long count = temp[1];

            if (current == B) return count;

            if (current * 2 <= B) {
                q.add(new long[] {current * 2, count + 1});
            }
            if (current * 10 + 1 <= B) {
                q.add(new long[] {current * 10 + 1, count + 1});
            }
        }

        return -1;
    }
}
