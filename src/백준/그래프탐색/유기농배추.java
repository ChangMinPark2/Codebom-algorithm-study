package 백준.그래프탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 유기농배추 {
    static int[][] graph;
    static boolean[][]visited;
    static int vertex, edge, count, result;
    static List<Integer> list = new ArrayList<>();
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int index = Integer.parseInt(br.readLine());

        while (index > 0) {
            String[] repo = br.readLine().split(" ");
            vertex = Integer.parseInt(repo[0]); //가로 길이
            edge = Integer.parseInt(repo[1]); //세로 길이
            count = Integer.parseInt(repo[2]);
            result = 0;

            graph = new int[edge][vertex];
            visited = new boolean[edge][vertex];

            for (int i = 0; i < count; i++) {
                repo = br.readLine().split(" ");
                int x = Integer.parseInt(repo[0]);
                int y = Integer.parseInt(repo[1]);

                graph[y][x] = 1;
            }

            for (int i = 0; i < graph.length; i++) {
                for (int j = 0; j < graph[0].length; j++) {
                    if (!visited[i][j] && graph[i][j] == 1) {
                        dfs(i, j);
                        result++;
                    }
                }
            }
            list.add(result);
            index--;
        }

        for (int i : list) {
            System.out.println(i);
        }
    }

    //i -> y j -> x
    static void dfs(int y, int x) {
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (isCheck(ny, nx) && !visited[ny][nx] && graph[ny][nx] == 1) {
                dfs(ny, nx);
            }
        }
    }

    static boolean isCheck(int y, int x) {
        return y >= 0 && y < edge && x >= 0 && x < vertex;
    }
}
