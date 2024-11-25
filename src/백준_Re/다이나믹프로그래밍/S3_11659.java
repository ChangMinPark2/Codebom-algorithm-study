package 백준_Re.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S3_11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] repo = br.readLine().split(" ");
        int n = Integer.parseInt(repo[0]);
        int m = Integer.parseInt(repo[1]);

        int[] arr = new int[n + 1];

        String[] repo2 = br.readLine().split(" ");

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(repo2[i - 1]) + arr[i - 1];
        }

        for (int i = 0; i < m; i++) {
            String[] repo3 = br.readLine().split(" ");
            int a = Integer.parseInt(repo3[0]);
            int b = Integer.parseInt(repo3[1]);

            System.out.println(arr[b] - arr[a - 1]);
        }
    }
}
