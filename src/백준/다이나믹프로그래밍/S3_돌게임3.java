package 백준.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S3_돌게임3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] mem = new int[1001];

        mem[1] = 1;
        mem[2] = 0;
        mem[3] = 1;
        mem[4] = 1;

        for (int i = 5; i <= n; i++) {
            //1 3 4 합이 3이면 뭐를 넣어도 다음 사람이 이긴다.
            if (mem[i - 1] + mem[i - 3] + mem[i - 4] < 3) {
                mem[i] = 1;
            } else mem[i] = 0;
        }

        System.out.println(mem[n] == 1 ? "SK" : "CY");
    }
}
