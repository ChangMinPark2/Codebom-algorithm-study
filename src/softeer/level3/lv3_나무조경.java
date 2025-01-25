package softeer.level3;

import java.util.*;
import java.io.*;

public class lv3_나무조경 {
    private static final int[] dy = {1, 0};
    private static final int[] dx = {0, 1};
    static int n;
    static int m = 4;
    static int[][] arr;
    static boolean[][] visited;
    static int answer = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        if(n == 2) {
            m = 2;
        }

        arr = new int[n][n];
        visited = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            String[] temp = br.readLine().split(" ");

            for(int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(temp[j]);
            }
        }

        dfs(0, 0);

        System.out.println(answer);
    }

    private static void dfs(int depth, int sum){
        if(depth == m) {
            answer = Math.max(answer, sum);
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j]) {
                    for(int z = 0; z < 2; z++) {
                        int ny = dy[z] + i;
                        int nx = dx[z] + j;

                        if(isCheck(ny, nx) && !visited[ny][nx]) {
                            visited[i][j] = true;
                            visited[ny][nx] = true;
                            dfs(depth + 1, sum + arr[i][j] + arr[ny][nx]);
                            visited[i][j] = false;
                            visited[ny][nx] = false;
                        }
                    }
                }
            }
        }
    }

    private static boolean isCheck(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < n;
    }
}
