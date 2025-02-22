package 백준.클래스4.re;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 5
 * 7
 * 3 8
 * 8 1 0
 * 2 7 4 4
 * 4 5 2 6 5
 */
public class S1_1932_RE2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            String[] temp = br.readLine().split(" ");

            for (int j = 1; j <= temp.length; j++) {
                arr[i][j] = Math.max(arr[i - 1][j], arr[i - 1][j - 1]) + Integer.parseInt(temp[j - 1]);
            }
        }

        int answer = -1;

        for (int i = 0; i <= n; i++) {
            answer = Math.max(answer, arr[n][i]);
        }

        System.out.println(answer);
    }
}
