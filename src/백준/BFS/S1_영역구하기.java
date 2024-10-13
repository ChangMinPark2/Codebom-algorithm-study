package 백준.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S1_영역구하기 {
    static int n, m, k;
    static int[][] map;
    static boolean[][] visited;
    static final int[] dx = {0, 0, -1, 1};
    static final int[] dy = {1, -1, 0, 0};
    static int count = 0;
    static List<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] repo = br.readLine().split(" ");

        n = Integer.parseInt(repo[1]); // 가로 7
        m = Integer.parseInt(repo[0]); // 세로 5
        k = Integer.parseInt(repo[2]); // 빈칸의 개수 3

        map = new int[m][n];
        visited = new boolean[m][n];

        for (int i = 0; i < k; i++) {
            String[] repo2 = br.readLine().split(" ");
            int x1 = Integer.parseInt(repo2[0]);
            int y1 = Integer.parseInt(repo2[1]);
            int x2 = Integer.parseInt(repo2[2]);
            int y2 = Integer.parseInt(repo2[3]);

            for (int y = y1; y < y2; y++) {
                for (int x = x1; x < x2; x++) {
                    map[y][x] = 1;
                }
            }
        }

        // BFS 탐색 시작
        for (int i = 0; i < m; i++) { // 행
            for (int j = 0; j < n; j++) { // 열
                if (map[i][j] == 0 && !visited[i][j]) {
                    count++;
                    answer.add(bfs(i, j));
                }
            }
        }

        System.out.println(count);
        Collections.sort(answer); // 크기 순으로 정렬
        for (int i : answer) {
            System.out.print(i + " ");
        }
    }

    static int bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        visited[x][y] = true;
        q.add(new int[]{x, y});
        int size = 1;

        while (!q.isEmpty()) {
            int[] temp = q.remove();
            int ax = temp[0];
            int ay = temp[1];

            for (int i = 0; i < 4; i++) {
                int qx = ax + dx[i];
                int qy = ay + dy[i];

                if (isCheck(qx, qy) && !visited[qx][qy] && map[qx][qy] == 0) {
                    size++;
                    visited[qx][qy] = true;
                    q.add(new int[]{qx, qy});
                }
            }
        }
        return size;
    }

    static boolean isCheck(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
