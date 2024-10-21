package 백준.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S1_정수삼각형 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        int[][] mem = new int[n][n];
        int answer = 0;

        for (int i = 0; i < n; i++) {
            String[] repo = br.readLine().split(" ");
            for (int j = 0; j <= i; j++) {
                arr[i][j] = Integer.parseInt(repo[j]);
            }
        }

        mem[0][0] = arr[0][0];
        answer = arr[0][0];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    mem[i][j] = mem[i - 1][j] + arr[i][j];
                } else if (j == i) { // 1.1 이라면
                    mem[i][j] = mem[i - 1][j - 1] + arr[i][j];
                } else {
                    mem[i][j] = Math.max(mem[i - 1][j - 1], mem[i - 1][j]) + arr[i][j];
                }
                answer = Math.max(answer, mem[i][j]);
            }
        }
        System.out.println(answer);
    }
}
