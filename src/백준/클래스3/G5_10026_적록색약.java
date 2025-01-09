package 백준.클래스3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class G5_10026_적록색약 {
    private static final int[] dx = {0, 0, -1, 1, 0, 0};
    private static final int[] dy = {1, -1, 0, 0, 0, 0};
    static int n, answer1, answer2;
    static char[][] arr;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new char[n][n];
        visited = new boolean[n][n];
        answer1 = 0;
        answer2 = 0;

        for (int i = 0; i < n; i++) {
            char[] temp = br.readLine().toCharArray();

            for (int j = 0; j < n; j++) {
                arr[i][j] = temp[j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    bfs(i, j);
                }
            }
        }

        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    bfs2(i, j);
                }
            }
        }

        System.out.println(answer1 + " " + answer2);
    }

    static void bfs(int y, int x) {
        char stand = arr[y][x];
        visited[y][x] = true;
        answer1++;
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[] {y, x});

        while (!q.isEmpty()) {
            int[] temp = q.remove();
            int oy = temp[0];
            int ox = temp[1];

            for (int i = 0; i < 4; i++) {
                int ny = oy + dy[i];
                int nx = ox + dx[i];

                if (isCheck(ny, nx) && !visited[ny][nx] && arr[ny][nx] == stand) {
                    visited[ny][nx] = true;
                    q.add(new int[]{ny, nx});
                }
            }
        }
    }

    static void bfs2(int y, int x) {
        visited[y][x] = true;
        answer2++;
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[] {y, x});
        char stand = arr[y][x];

        while (!q.isEmpty()) {
            int[] temp = q.remove();
            int oy = temp[0];
            int ox = temp[1];

            for (int i = 0; i < 4; i++) {
                int ny = oy + dy[i];
                int nx = ox + dx[i];

                if (isCheck(ny, nx) && !visited[ny][nx]) {
                    if (stand == 'B' && arr[ny][nx] == 'B') {
                        visited[ny][nx] = true;
                        q.add(new int[]{ny, nx});
                    } else if (stand == 'G' && (arr[ny][nx] == 'G' || arr[ny][nx] == 'R')){
                        visited[ny][nx] = true;
                        q.add(new int[]{ny, nx});
                    } else if (stand == 'R' && (arr[ny][nx] == 'G' || arr[ny][nx] == 'R')) {
                        visited[ny][nx] = true;
                        q.add(new int[]{ny, nx});
                    }
                }
            }
        }
    }

    private static boolean isCheck(int ny, int nx) {
        return ny >= 0 && ny < n && nx >= 0 && nx < n;
    }
}
