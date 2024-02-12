package 백준.트리;
import java.util.*;
import java.io.*;

public class G5_토마토 {
    static int [][] graph;
    static int m, n, count = 0;
    static int[] dx = {0, 0, -1 , 1};
    static int[] dy = {-1, 1, 0, 0};
    static Queue<int[]> q = new LinkedList<>();
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //그래프를 받으면서 1일 때 q의 삽입
        String[] input = br.readLine().split(" ");
        m = Integer.parseInt(input[0]); //가로
        n = Integer.parseInt(input[1]); //세로

        graph = new int[n][m];

        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(input[j]);

                if (graph[i][j] == 1) {
                    q.add(new int[] {i, j, 0});
                }
            }
        }
        //bfs를 돌린다
        bfs();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(count);
    }

    static void bfs() {
        while (!q.isEmpty()) {
            int[] temp = q.remove();
            int y = temp[0];
            int x = temp[1];
            int depth = temp[2];
            count = depth;

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (isCheck(ny, nx) && graph[ny][nx] == 0) {
                    graph[ny][nx] = 1;

                    q.add(new int[]{ny, nx, depth + 1});
                }
            }
        }
    }

    static boolean isCheck(int ny, int nx) {
        return ny >= 0 && ny < n && nx >= 0 && nx < m;
    }
}
