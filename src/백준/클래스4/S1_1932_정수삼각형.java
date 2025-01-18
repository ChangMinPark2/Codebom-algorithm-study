package 백준.클래스4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * N->500 dp
 * 왼쪽 아래 대각, 오른쪽 아래 대각
 * 왼쪽 아래대각 -> y + 1, x
 * 오른쪽 아래 대각 -> y + 1, x + 1
 * 최대구하기
 */
public class S1_1932_정수삼각형 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] mem = new int[n][n];
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] repo = br.readLine().split(" ");

            for (int j = 0; j < repo.length; j++) {
                arr[i][j] = Integer.parseInt(repo[j]);
            }
        }

        mem[0][0] = arr[0][0];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    mem[i][j] = mem[i - 1][j] + arr[i][j];
                } else {
                    mem[i][j] = Math.max(mem[i - 1][j], mem[i - 1][j - 1]) + arr[i][j];
                }
            }
        }

        int answer = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, mem[n - 1][i]);
        }

        System.out.println(answer);
    }
}
