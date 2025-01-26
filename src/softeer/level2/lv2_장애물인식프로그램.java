package softeer.level2;

import java.io.*;
import java.util.*;


public class lv2_장애물인식프로그램 {
    private static int[] dy = {-1, 1, 0, 0};
    private static int[] dx = {0, 0, -1, 1};
    static int[][] arr;
    static boolean[][] visited;
    static int n;
    static int answer = 0;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        visited = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            String[] temp = br.readLine().split("");

            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(temp[j]);
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j] && arr[i][j] == 1) {
                    bfs(i, j);
                    answer++;
                }
            }
        }

        System.out.println(answer);

        while(!pq.isEmpty()) {
            System.out.println(pq.remove());
        }
    }

    private static void bfs(int y, int x) {
        Deque<int[]> q = new ArrayDeque<>();
        int sum = 1;
        q.add(new int[] {y, x});
        visited[y][x] = true;

        while(!q.isEmpty()) {
            int[] temp = q.remove();
            int oy = temp[0];
            int ox = temp[1];

            for(int i = 0; i < 4; i++) {
                int ny = oy + dy[i];
                int nx = ox + dx[i];

                if(isCheck(ny, nx) && !visited[ny][nx] && arr[ny][nx] == 1) {
                    visited[ny][nx] = true;
                    q.add(new int[] {ny, nx});
                    sum++;
                }
            }
        }

        pq.add(sum);
    }

    private static boolean isCheck(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < n;
    }
}
