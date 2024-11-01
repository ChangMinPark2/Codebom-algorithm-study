package 백준.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 2
 * 5
 * 50 10 100 20 40
 * 30 50 70 10 60
 * 7
 * 10 30 10 50 100 20 40
 * 20 40 30 50 60 20 80
 */
public class S1_9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(br.readLine());
            String[] repo = br.readLine().split(" ");
            String[] repo2 = br.readLine().split(" ");
                // XX
            int[][] arr = new int[2][temp + 1];
            int[][] mem = new int[2][temp + 1];

            for (int j = 1; j <= temp; j++) {
                arr[0][j] = Integer.parseInt(repo[j - 1]);
                arr[1][j] = Integer.parseInt(repo2[j - 1]);
            }

            mem[0][1] = arr[0][1];
            mem[1][1] = arr[1][1];

            if (temp == 1) {
                System.out.println(Math.max(mem[0][1], mem[1][1]));
                continue;
            }

            for (int j = 2; j <= temp; j++) {
                mem[0][j] = Math.max(mem[1][j - 1], mem[1][j - 2]) + arr[0][j];
                mem[1][j] = Math.max(mem[0][j - 1], mem[0][j - 2]) + arr[1][j];
            }

            System.out.println(Math.max(mem[1][temp], mem[0][temp]));
        }
    }
}
