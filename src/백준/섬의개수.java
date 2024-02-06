package 백준;

import java.io.*;
import java.util.*;

/*
상 하 좌 우 대각선 모두 땅으로만 이루어진 갯수를 구하는 문제. dfs로 갯수 구하기.
 */
public class 섬의개수 {
    static int width, height, count;
    static boolean[][] visited;
    static List<Integer> answer = new ArrayList<>();
    static int[][] graph;
    static int[] dx = {0, 0, -1, 1, -1, -1, 1, 1};
    static int[] dy = {-1, 1, 0, 0, -1, 1, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String[] input = br.readLine().split(" ");
            width = Integer.parseInt(input[0]); //3
            height = Integer.parseInt(input[1]); //2

            if (width == 0 && height == 0) break;

            graph = new int[height][width];
            visited = new boolean[height][width];

            for (int i = 0; i < height; i++) { //2
                String[] input2 = br.readLine().split(" "); //111

                for (int j = 0; j < width; j++) { // 3
                    graph[i][j] = Integer.parseInt(input2[j]);
                }
            }
            count = 0;

            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (!visited[i][j] && graph[i][j] == 1) {
                        dfs(i, j);
                        count++;
                    }
                }
            }
            answer.add(count);
        }

        for (int i : answer) {
            System.out.println(i);
        }
    }

    static void dfs(int height, int width) {
        visited[height][width] = true;

        for (int i = 0; i < dx.length; i++) {
            int nx = width + dx[i];
            int ny = height + dy[i];
            if (isCheck(nx, ny) && !visited[ny][nx] && graph[ny][nx] == 1) {
                dfs(ny, nx);
            }
        }
    }

    static boolean isCheck(int x, int y) {
        return x >= 0 && x < width && y >= 0 && y < height;
    }
}
