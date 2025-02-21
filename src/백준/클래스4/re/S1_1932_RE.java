package 백준.클래스4.re;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S1_1932_RE {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] mem = new int[n][n];
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] temp = br.readLine().split(" ");

            for (int j = 0; j < temp.length; j++) {
                arr[i][j] = Integer.parseInt(temp[j]);
            }
        }

        mem[0][0] = arr[0][0];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    mem[i][j] = arr[i][j] + mem[i - 1][j];
                } else if (j == n - 1) {
                    mem[i][j] = arr[i][j] + mem[i - 1][j - 1];
                } else {
                    mem[i][j] = arr[i][j] + Math.max(mem[i - 1][j], mem[i - 1][j - 1]);
                }
            }
        }

        int answer = -1;

        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, mem[n - 1][i]);
        }

        System.out.println(answer);
    }
}
