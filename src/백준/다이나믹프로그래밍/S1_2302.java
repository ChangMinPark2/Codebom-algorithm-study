package 백준.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 입력 예시
 * 9
 * 2
 * 4
 * 7
 */
public class S1_2302 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[] mem = new int[41];

        mem[0] = 1;
        mem[1] = 1;
        mem[2] = 2;

        for (int i = 3; i < 41; i++) {
            mem[i] = mem[i - 1] + mem[i - 2];
        }

        int answer = 1;
        int before = 0;

        for (int i = 0; i < m; i++) {
            int temp = Integer.parseInt(br.readLine());
            answer *= mem[temp - before - 1];
            before = temp;
        }

        answer *= mem[n - before];

        System.out.println(answer);
    }
}
