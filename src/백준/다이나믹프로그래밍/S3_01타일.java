package 백준.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1 또는 00만의 타일을 가지고 있음
 * 1일때 1만 만들수 있음. 2일때는 00, 11만 만들 수 있음. 01, 10은 X
 * 타일들이 무한히 있을 때, 만들 수 있는 모든 가짓수를 세기
 */
public class S3_01타일 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] mem = new long[1000001];

        mem[1] = 1;
        mem[2] = 2;

        for (int i = 3; i <= n; i++) {
            mem[i] = (mem[i - 1] + mem[i - 2]) % 15746;
        }

        System.out.println(mem[n]);
    }
}
