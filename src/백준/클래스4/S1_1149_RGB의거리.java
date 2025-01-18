package 백준.클래스4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * N-> 1000 (dfs bfs 2차dp)정도
 * 빨 파 초로 칠하는 비용이 주어질 때 모든 집을 칠하는 비용의 최솟값
 * 1번의 집의 색은, 2번의 색과 같지 않아야 한다.
 * dp로 가능할듯?
 * 0 -> 1, 2
 * 1 -> 0, 2
 * 2 -> 2, 1
 */
public class S1_1149_RGB의거리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][3];
        int[][] mem = new int[n][3];

        for (int i = 0; i < n; i++) {
            String[] repo = br.readLine().split(" ");
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(repo[j]);
            }
        }

        mem[0][0] = arr[0][0];
        mem[0][1] = arr[0][1];
        mem[0][2] = arr[0][2];

        for (int i = 1; i < n; i++) {
            mem[i][0] = Math.min(mem[i - 1][1], mem[i - 1][2]) + arr[i][0];
            mem[i][1] = Math.min(mem[i - 1][0], mem[i - 1][2]) + arr[i][1];
            mem[i][2] = Math.min(mem[i - 1][0], mem[i - 1][1]) + arr[i][2];
        }

        System.out.println(Math.min(mem[n - 1][0], Math.min(mem[n - 1][1], mem[n - 1][2])));
    }
}
