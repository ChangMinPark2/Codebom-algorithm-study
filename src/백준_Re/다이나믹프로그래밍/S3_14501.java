package 백준_Re.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 7
 *1 3 10 -> mem[4] = 10;
 *2 5 20 -> mem[7] -> 20
 *3 1 10 -> mem[4] = 10
 *4 1 20 -> mem[5] : 20 + 10; = 30
 * mem[6] -> 30
 *5 2 15 -> mem[7] : 15; mem[7] -> 45
 *6 4 40
 *7 2 200
 */
public class S3_14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[2][n + 1];
        int[] mem = new int[n + 2];

        for (int i = 1; i <= n; i++) {
            String[] repo = br.readLine().split(" ");

            int time = Integer.parseInt(repo[0]);
            int money = Integer.parseInt(repo[1]);

            arr[0][i] = time;
            arr[1][i] = money;
        }

        for (int i = 1; i <= n; i++) {
            if (arr[0][i] + i <= n + 1) {
                int now = arr[0][i] + i; // 4
                mem[now] = Math.max(mem[now], mem[i] + arr[1][i]);
            }
            mem[i + 1] = Math.max(mem[i + 1], mem[i]);
        }

        System.out.println(mem[n + 1]);
    }
}
