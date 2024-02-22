package 백준.그래프탐색;
import java.util.*;
import java.io.*;
public class G5_적록색약 {
    static int n;
    static String[][] graph;
    static boolean[][] visited;
    static int ans1, ans2;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new String[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                graph[i][j] = input[j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]){
                    dfs(i, j);
                    ans1++;
                }
            }
        }
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]){
                    rgbDfs(i, j);
                    ans2++;
                }
            }
        }
        System.out.println(ans1 + " " + ans2);
    }
    static void rgbDfs(int y, int x) {
        visited[y][x] = true;
        redAndGreen(y, x);
        blue(y, x);
    }

    static void dfs(int y, int x) {
        visited[y][x] = true;
        red(y, x);
        green(y, x);
        blue(y, x);
    }

    static void redAndGreen(int y, int x) {
        if (graph[y][x].equals("R") || graph[y][x].equals("G")) {
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (isCheck(ny, nx) && !visited[ny][nx] && (graph[ny][nx].equals("R") || graph[ny][nx].equals("G"))){
                    rgbDfs(ny, nx);
                }
            }
        }
    }

    static void rgbBlue(int y, int x) {
        if (graph[y][x].equals("B")) {
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (isCheck(ny, nx) && !visited[ny][nx] && graph[ny][nx].equals("B")){
                    rgbDfs(ny, nx);
                }
            }
        }
    }

    static void red(int y, int x) {
        if (graph[y][x].equals("R")) {
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (isCheck(ny, nx) && !visited[ny][nx] && graph[ny][nx].equals("R")){
                    dfs(ny, nx);
                }
            }
        }
    }

    static void blue(int y, int x) {
        if (graph[y][x].equals("B")) {
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (isCheck(ny, nx) && !visited[ny][nx] && graph[ny][nx].equals("B")){
                    dfs(ny, nx);
                }
            }
        }
    }

    static void green(int y, int x) {
        if (graph[y][x].equals("G")) {
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (isCheck(ny, nx) && !visited[ny][nx] && graph[ny][nx].equals("G")){
                    dfs(ny, nx);
                }
            }
        }
    }

    static boolean isCheck(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < n;
    }
}
