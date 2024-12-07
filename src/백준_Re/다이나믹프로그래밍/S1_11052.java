package 백준_Re.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 카드 '팩' 형태로만 구매
 * n가지가 존재 <= 1000
 * n개의 카드를 구매해야 하는 금액의 최댓값.
 * <p>
 * n = 2 라면, mem[2] = mem[0] + arr[2], mem[1] + arr[1]
 * n = 4 일때
 * mem[i] = mem[i - 4] + arr[4]
 * mem[i] = mem[i - 3] + arr[3]
 * mem[i] = mem[i - 2] + arr[2]
 * mem[i] = mem[i - 1] + arr[1]
 */
public class S1_11052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] repo = br.readLine().split(" ");
        int[] arr = new int[n + 1];
        int[] mem = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(repo[i - 1]);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                mem[i] = Math.max(mem[i], mem[i - j] + arr[j]);
            }
        }

        System.out.println(mem[n]);
    }

}
