package 백준.클래스3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S3_2606_바이러스 {
    static int n, m;
    static int[][] arr;
    static boolean[] visited;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        arr = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            String[] temp = br.readLine().split(" ");
            int a = Integer.parseInt(temp[0]);
            int b = Integer.parseInt(temp[1]);

            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        dfs(1);
        System.out.println(answer);
    }

    private static void dfs(int start) {
        visited[start] = true;

        for (int i = 1; i <= n; i++) {
            if (!visited[i] && arr[start][i] == 1) {
                dfs(i);
                answer++;
            }
        }
    }
}
