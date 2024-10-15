package 백준.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 계단은 한 번에 한 계단 or 두 계단 오를 수 있다.
 * 연속으로 3개의 계단을 모두 밟아서는 안 된다. 시작은 x
 * 마지막 도착 계단은 반드시 밟아야 한다.
 */
public class S3_계단오르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] mem = new int[n + 1];
        int[] floor = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            floor[i] = Integer.parseInt(br.readLine());
        }

        mem[1] = floor[1];

        if (n >= 2) {
            mem[2] = floor[1] + floor[2];
        }

        for (int i = 3; i <= n; i++) {
            mem[i] = Math.max(mem[i - 2], mem[i - 3] + floor[i - 1]) + floor[i];
        }

        System.out.println(mem[n]);
    }
}
