package 백준.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class G5_15486 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n + 2][2];
        int[] mem = new int[n + 2];

        for (int i = 1; i <= n; i++) {
            String[] repo = br.readLine().split(" ");
            int time = Integer.parseInt(repo[0]);
            int money = Integer.parseInt(repo[1]);

            arr[i][0] = time;
            arr[i][1] = money;
        }

        int max = -1;

        for (int i = 1; i <= n + 1; i++) {
            if (max < mem[i]) {
                max = mem[i];
            }

            int temp = i + arr[i][0];

            if (temp < n + 2) {
                mem[temp] = Math.max(mem[temp], max + arr[i][1]);
            }
        }

        System.out.println(mem[n + 1]);
    }
}
