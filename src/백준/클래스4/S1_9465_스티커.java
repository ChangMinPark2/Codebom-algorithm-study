package 백준.클래스4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * n이 10만 탐색 x
 * <p>
 * 스티커 2n, 2가 y축 n: x축
 * 위의 경우, i - 1 x - 1, i - 1 x - 2 임
 */
public class S1_9465_스티커 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {

            int n = Integer.parseInt(br.readLine());

            int[][] mem = new int[2][n + 1];
            int[][] arr = new int[2][n + 1];

            for (int j = 0; j < 2; j++) {
                String[] temp = br.readLine().split(" ");

                for (int z = 1; z <= n; z++) {
                    arr[j][z] = Integer.parseInt(temp[z - 1]);
                }
            }

            mem[0][1] = arr[0][1];
            mem[1][1] = arr[1][1];

            for (int j = 2; j <= n; j++) {
                mem[0][j] = Math.max(mem[1][j - 1], mem[1][j - 2]) + arr[0][j];
                mem[1][j] = Math.max(mem[0][j - 1], mem[0][j - 2]) + arr[1][j];
            }

            System.out.println(Math.max(mem[0][n], mem[1][n]));
        }

    }
}
