package 백준.그래프탐색;

import java.io.*;
import java.util.*;

public class 단지번호붙이기 {
    static int vertex, nowX, nowY;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int totalCount, count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        vertex = Integer.parseInt(br.readLine());
        graph = new int[vertex][vertex];
        visited = new boolean[vertex][vertex];
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < vertex; i++) {
            String[] repo = br.readLine().split("");
            for (int j = 0; j < repo.length; j++) {
                graph[i][j] = Integer.parseInt(repo[j]);
            }
        }

        for (int i = 0; i < vertex; i++) {
            for (int j = 0; j < vertex; j++) {
                if (!visited[i][j] && graph[i][j] == 1) {
                    totalCount++;
                    count = 0;
                    dfs(i, j);
                    list.add(count);
                }
            }
        }

        Collections.sort(list);
        System.out.println(totalCount);
        
        for (int i : list) {
            System.out.println(i);
        }
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;
        count++;

        for (int i = 0; i < 4; i++) {
            nowX = dx[i] + x;
            nowY = dy[i] + y;

            if (isCheck() && !visited[nowX][nowY] && graph[nowX][nowY] == 1) {
                visited[nowX][nowY] = true;
                dfs(nowX, nowY);
            }
        }
    }

    static boolean isCheck() {
        return nowX >= 0 && nowX < vertex && nowY >= 0 && nowY < vertex;
    }
}
