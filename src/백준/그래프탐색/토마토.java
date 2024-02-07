package 백준.그래프탐색;

import java.util.*;
import java.io.*;

/**
 * M -> 가로
 * N -> 세로
 * H -> 높이
 * 1은 익고, 0은 익지않고, -1은 토마토가 없다.
 * 며칠이 지났을때 다 익게 되는가? -> dfs가 몇 번 호출 되는가.
 * 모두 익어 있으면 0을 호출, 모두 익지 못하는 상황은 -1
 **/
public class 토마토 {
    static int[][][] graph;
    static boolean[][][] visited;
    static int m, n, h, answer;
    static int[] dx = {0, 0, -1, 1, 0, 0}; //위 아래 왼쪽 오른쪽 앞 뒤
    static int[] dy = {0, 0, 0, 0, -1, 1};
    static int[] dh = {-1, 1, 0, 0, 0, 0};
    static Queue<int[]> q = new LinkedList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        m = Integer.parseInt(input[0]); //가로
        n = Integer.parseInt(input[1]); //세로
        h = Integer.parseInt(input[2]); //높이

        graph = new int[h][n][m];
        visited = new boolean[h][n][m];

        //그래프 채우기
        for (int z = 0; z < h; z++) {
            for (int i = 0; i < n; i++) {
                input = br.readLine().split(" ");
                for (int j = 0; j < m; j++) {
                    graph[z][i][j] = Integer.parseInt(input[j]);
                }
            }
        }

        answer = 0;

        //탐색
        for (int z = 0; z < h; z++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (!visited[z][i][j] && graph[z][i][j] == 1) {
                        q.add(new int[]{z, i, j, 0});
                    }
                }
            }
        }

        while (!q.isEmpty()) {
            int[] temp = q.remove();
            bfs(temp[0], temp[1], temp[2], temp[3]);
            answer = temp[3];
        }


        for (int z = 0; z < h; z++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (graph[z][i][j] == 0) {
                        answer = -1;
                    }
                }
            }
        }

        System.out.println(answer);
    }

    static void bfs(int z, int y, int x, int count) {
        visited[z][y][x] = true;

        for (int i = 0; i < dx.length; i++) {
            int nh = dh[i] + z;
            int ny = dy[i] + y;
            int nx = dx[i] + x;

            if (isCheck(nh, ny, nx) && !visited[nh][ny][nx] && graph[nh][ny][nx] == 0) {
                visited[nh][ny][nx] = true;
                graph[nh][ny][nx] = 1;
                q.add(new int[]{nh, ny, nx, count + 1});
            }
        }
    }


    static boolean isCheck(int z, int i, int j) {
        return z >= 0 && z < h && i >= 0 && i < n && j >= 0 && j < m;
    }
}
