package 백준.클래스4.re;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 3
 * 26 40 83
 * 49 60 57
 * 13 89 99
 */
public class S1_1149_RE {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n + 1][3];

        for (int i = 1; i <= n; i++) {
            String[] temp = br.readLine().split(" ");
            int r = Integer.parseInt(temp[0]);
            int g = Integer.parseInt(temp[1]);
            int b = Integer.parseInt(temp[2]);

            arr[i][0] = Math.min(arr[i - 1][1], arr[i - 1][2]) + r;
            arr[i][1] = Math.min(arr[i - 1][0], arr[i - 1][2]) + g;
            arr[i][2] = Math.min(arr[i - 1][0], arr[i - 1][1]) + b;
        }

        int min = Integer.MAX_VALUE;

        min = Math.min(arr[n][0], Math.min(arr[n][1], arr[n][2]));

        System.out.println(min);
    }
}
