package 백준.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class S1_나이트의이동 {

    static int[][] map;
    static boolean[][] visited;
    static int n;
    static int x1, y1, x2, y2;
    //시계방향순으로
    static final int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
    static final int[] dy = {2, 1, -1, -2, -2, -1, 1, 2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = br.readLine();

        for (int i = 0; i < Integer.parseInt(input); i++) {
            n = Integer.parseInt(br.readLine());
            map = new int[n][n];
            visited = new boolean[n][n];

            String[] repo = br.readLine().split(" ");
            String[] repo2 = br.readLine().split(" ");
            //현재
            x1 = Integer.parseInt(repo[0]);
            y1 = Integer.parseInt(repo[1]);
            //목표
            x2 = Integer.parseInt(repo2[0]);
            y2 = Integer.parseInt(repo2[1]);

            bfs();

            sb.append(map[x2][y2]).append("\n");
        }
        System.out.println(sb);
    }

    static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x1, y1});
        visited[x1][y1] = true;

        while (!q.isEmpty()) {
            int[] now = q.remove();
            int nx = now[0];
            int ny = now[1];

            for (int i = 0; i < 8; i++) {
                int ax = nx + dx[i];
                int ay = ny + dy[i];

                if (isCheck(ax, ay) && !visited[ax][ay]) {
                    q.add(new int[] {ax, ay});
                    map[ax][ay] = map[nx][ny] + 1;
                    visited[ax][ay] = true;
                }
            }
        }
    }

    static boolean isCheck(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }
}
