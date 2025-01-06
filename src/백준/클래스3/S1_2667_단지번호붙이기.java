package 백준.클래스3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * bfs의 경우 지역변수 활용.
 * dfs의 경우 탐색 시작부분에서 활용해야할듯?
 * n -> 25
 */
public class S1_2667_단지번호붙이기 {
    private final static int[] dx = {0, 0, -1, 1};
    private final static int[] dy = {1, -1, 0, 0};
    static int n;
    static boolean[][] visited;
    static int[][] arr;
    static List<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] repo = br.readLine().split(" ");
        n = Integer.parseInt(repo[0]);
        visited = new boolean[n][n];
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] temp = br.readLine().split("");

            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(temp[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && arr[i][j] == 1) {
                    bfs(i, j);
                }
            }
        }

        Collections.sort(answer);
        System.out.println(answer.size());

        for (int i : answer) {
            System.out.println(i);
        }
    }

    private static void bfs(int y, int x) {
        Deque<int[]> q = new ArrayDeque<>();
        visited[y][x] = true;
        int sum = 1;
        q.add(new int[] {y, x});

        while (!q.isEmpty()) {
            int[] temp = q.remove();
            int ny = temp[0];
            int nx = temp[1];

            for (int i = 0; i < 4; i++) {
                int oy = dy[i] + ny;
                int ox = dx[i] + nx;

                if (isCheck(oy, ox) && !visited[oy][ox] && arr[oy][ox] == 1) {
                    visited[oy][ox] = true;
                    q.add(new int[] {oy, ox});
                    sum++;
                }
            }
        }

        answer.add(sum);
    }

    private static boolean isCheck(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < n;
    }
}
