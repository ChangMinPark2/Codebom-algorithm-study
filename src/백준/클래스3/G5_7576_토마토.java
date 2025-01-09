package 백준.클래스3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class G5_7576_토마토 {
    private static final int[] dx = {0, 0, -1, 1, 0, 0};
    private static final int[] dy = {1, -1, 0, 0, 0, 0};
    static int y, x;
    static int answer;
    static boolean[][] visited;
    static int[][] arr;
    static Deque<int[]> q = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] repo = br.readLine().split(" ");
        x = Integer.parseInt(repo[0]);
        y = Integer.parseInt(repo[1]);

        arr = new int[y][x];
        visited = new boolean[y][x];

        for (int i = 0; i < y; i++) {
            String[] temp = br.readLine().split(" ");

            for (int j = 0; j < x; j++) {
                arr[i][j] = Integer.parseInt(temp[j]);
                if (arr[i][j] == 1) {
                    q.add(new int[]{i, j, 0});
                    visited[i][j] = true;
                }
            }
        }

        answer = 0;

        bfs();

        for (int[] i : arr) {
            for (int j : i) {
                if (j == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(answer);
    }

    static void bfs() {
        while (!q.isEmpty()) {
            int[] temp = q.remove();

            int ny = temp[0];
            int nx = temp[1];
            int score = temp[2];
            answer = score;

            for (int i = 0; i < 4; i++) {
                int oy = ny + dy[i];
                int ox = nx + dx[i];

                if (isCheck(oy, ox) && !visited[oy][ox] && arr[oy][ox] == 0) {
                    visited[oy][ox] = true;
                    arr[oy][ox] = 1;
                    q.add(new int[]{oy, ox, score + 1});
                }
            }
        }
    }

    private static boolean isCheck(int ny, int nx) {
        return ny >= 0 && ny < y && nx >= 0 && nx < x;
    }
}

