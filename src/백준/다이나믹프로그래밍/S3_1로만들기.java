package 백준.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 1. n이 3으로 나누어 떨어지면 3으로 나눈다.
 * 2. n이 2로 나누어 떨어지면 2로 나눈다.
 * 3. 1을 뺀다
 *
 * 1 ~ 3을 사용하여 1을 만들려고 한다.
 * 연산을 사용하는 최솟값을 구하기
 * 1000000 -> n의 최대
 *
 */
public class S3_1로만들기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] mem = new int[n + 1];

        mem[0] = 0;
        mem[1] = 0;

        for (int i = 2; i <= n; i++){
            mem[i] = mem[i-1] + 1;

            if (i % 2 == 0) mem[i] = Math.min(mem[i], mem[i/2] + 1);
            if (i % 3 == 0) mem[i] = Math.min(mem[i], mem[i/3] + 1);
        }
        System.out.println(mem[n]);
        System.out.println(Arrays.toString(mem));
    }
}
