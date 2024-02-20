package 백준.그래프탐색;

import java.io.*;
import java.util.*;

public class G4_연구소_SAMSUNG {
    static final int WALL = 3;
    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, 1, 0, -1};
    static int n, m;
    static int totalWall = 3;
    static int[][] board;
    static List<int[]> initVirus = new ArrayList<>();
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        board = new int[n][m];

        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");

            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(input[j]);

                if (board[i][j] == 2) {
                    initVirus.add(new int[] {i, j});
                } else if (board[i][j] == 1) {
                    totalWall += 1;
                }
            }
        }

        dfs(0);
        System.out.println(n * m - (totalWall + answer));
    }

    private static void dfs(int wall) {
        if (wall == WALL) {
            bfs();
            return;
        }

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                if (board[y][x] == 0) {
                    board[y][x] = 1;
                    dfs(wall + 1);
                    board[y][x] = 0;
                }
            }
        }
    }

    private static void bfs() {
        int virusCount = initVirus.size();
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> virus = new LinkedList<>(initVirus);

        while (!virus.isEmpty()) {
            int[] temp = virus.remove();
            int y = temp[0];
            int x = temp[1];

            for (int i = 0; i < 4; i++) {
                int ny = dy[i] + y;
                int nx = dx[i] + x;

                if (ny == -1 || nx == -1 || ny == n || nx == m || board[ny][nx] != 0 || visited[ny][nx]) {
                    continue;
                }

                visited[ny][nx] = true;
                virus.add(new int[] {ny, nx});
                virusCount += 1;
            }
        }

        answer = Math.min(answer, virusCount);
    }
}
