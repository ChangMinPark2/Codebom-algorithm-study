package 백준_Re.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1, 2, 3 을 채웠을 떄,
 * n이 4일 때, 2 4 냐, 1 3 4 냐 이다.
 * 그러면, mem[n-2], mem[n-3] + arr[n - 1] 중 비교해보면 된다. <점화식>
 */
public class S3_2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n + 1];
        int[] mem = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        mem[1] = arr[1];

        if (n >= 2) {
            mem[2] = arr[2] + arr[1];
        }

        for (int i = 3; i <= n; i++) {
            mem[i] = Math.max(mem[i - 2], mem[i - 3] + arr[i - 1]) + arr[i];
            System.out.println("들어오나 체크");
        }

        System.out.println(mem[n]);
    }
}
