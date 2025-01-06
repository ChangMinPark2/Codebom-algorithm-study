package 백준.클래스3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 공통 123
 * 1: 1
 * 2: 2
 * 3: 4
 * 4: 7
 */
public class S3_9095_123더하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] mem = new int[12];
        mem[1] = 1;
        mem[2] = 2;
        mem[3] = 4;

        for (int i = 4; i < 12; i++) {
            mem[i] = mem[i - 1] + mem[i - 2] + mem[i - 3];
        }

        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(br.readLine());
            sb.append(mem[temp]).append("\n");
        }

        System.out.println(sb);
    }
}
