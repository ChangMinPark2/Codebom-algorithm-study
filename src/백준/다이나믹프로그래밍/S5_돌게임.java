package 백준.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * N개의 돌이 있다.
 * 돌은 1개 혹은 3개를 가져갈 수 있다.
 * 마지막 돌을 가져가는 사람이 게임을 이긴다.
 * 두 사람이 완벽하게 게임을 했을 때, 이기는 사람을 구하기.
 * 상근이가 이기면 SK, 창영이가 이기면 CY를 출력한다.
 * 게임은 상근이가 먼저 시작한다.
 *
 * <풀이>
 * 최적의 갯수를 구한다.
 * 그 갯수가 홀수라면 상근, 짝수라면 창영
 */
public class S5_돌게임 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] mem = new int[1001];

        mem[1] = 1;
        mem[2] = 2;
        mem[3] = 1;

        for (int i = 4; i <= n; i++) {
            mem[i] = Math.min(mem[i - 1], mem[i - 3]) + 1;
        }
        if (mem[n] % 2 == 0) {
            System.out.println("CY");
        } else System.out.println("SK");
    }
}
