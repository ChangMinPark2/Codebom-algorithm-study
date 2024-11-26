package 백준_Re.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1은 낱개, 0은 가능
 * n -> 1일 떄 , 1개
 * n -> 2일 떄 , 2개
 * n -> 3일 떄, 111 100 001 3개?
 * 4일 떄, 5개
 * n-1  + n-2
 */
public class S3_1904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] mem = new int[1000001];

        mem[1] = 1;
        mem[2] = 2;

        for (int i = 3; i < 1000001; i++) {
            mem[i] = (mem[i - 1] + mem[i - 2]) % 15746;
        }

        System.out.println(mem[n]);
    }
}
