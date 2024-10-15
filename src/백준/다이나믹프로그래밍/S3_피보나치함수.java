package 백준.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S3_피보나치함수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] mem = new int[41][2];

        mem[0][0] = 1;
        mem[0][1] = 0;
        mem[1][0] = 0;
        mem[1][1] = 1;

        for (int i = 2; i < 41; i++) {
            mem[i][0] = mem[i - 1][0] + mem[i - 2][0];
            mem[i][1] = mem[i - 1][1] + mem[i - 2][1];
        }

        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(br.readLine());

            System.out.println(mem[temp][0] + " " + mem[temp][1]);
        }

    }
}
