package 백준.클래스4.re;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G5_2096_RE {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] maxArr = new int[n + 1][3];
        int[][] minArr = new int[n + 1][3];

        for (int i = 1; i <= n; i++) {
            String[] temp = br.readLine().split(" ");

            maxArr[i][0] = Math.max(maxArr[i - 1][0], maxArr[i - 1][1]) + Integer.parseInt(temp[0]);
            maxArr[i][1] = Math.max(maxArr[i - 1][0], Math.max(maxArr[i - 1][1], maxArr[i - 1][2])) + Integer.parseInt(temp[1]);
            maxArr[i][2] = Math.max(maxArr[i - 1][1], maxArr[i - 1][2]) + Integer.parseInt(temp[2]);

            minArr[i][0] = Math.min(minArr[i - 1][0], minArr[i - 1][1]) + Integer.parseInt(temp[0]);
            minArr[i][1] = Math.min(minArr[i - 1][0], Math.min(minArr[i - 1][1], minArr[i - 1][2])) + Integer.parseInt(temp[1]);
            minArr[i][2] = Math.min(minArr[i - 1][1], minArr[i - 1][2]) + Integer.parseInt(temp[2]);
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        max = Math.max(maxArr[n][0], Math.max(maxArr[n][1], maxArr[n][2]));
        min = Math.min(minArr[n][0], Math.min(minArr[n][1], minArr[n][2]));

        System.out.println(max + " " + min);
    }
}
