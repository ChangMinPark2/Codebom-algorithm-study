package 백준.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S3_퇴사 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            String[] repo = br.readLine().split(" ");

            int time = Integer.parseInt(repo[0]);
            int money = Integer.parseInt(repo[1]);

            arr[i][0] = time;
            arr[i][1] = money;
        }

        int[] mem = new int[n + 2];

        for (int i = n; i > 0; i--) {
            if (i + arr[i][0] > n + 1) { // 퇴사일을 넘긴다면
                mem[i] = mem[i + 1]; // 다음 날짜. 1일 스타트와 2일 스타트중에서 1일이 더 많이 범
            } else {
                mem[i] = Math.max(mem[i + 1], mem[i + arr[i][0]]+ arr[i][1]);
            }
        }

        System.out.println(mem[1]);
    }
}
