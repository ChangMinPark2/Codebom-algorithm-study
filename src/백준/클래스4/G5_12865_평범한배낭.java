package 백준.클래스4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * N <= 100개
 * 물건 N
 * 무게 W, 가치 V
 * V 만큼 즐길 수 있다.
 * 최대 K 만큼 무게만을 넣어서 여행가기.
 * 가치의 최댓값
 */
public class G5_12865_평범한배낭 {
    static int n, k;
    static int[][] mem;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        n = Integer.parseInt(temp[0]); //갯수
        k = Integer.parseInt(temp[1]); //제한무게
        int[] w = new int[n + 1];
        int[] v = new int[n + 1];
        int[][] mem = new int[n + 1][k + 1];

        for (int i = 1; i <= n; i++) {
            String[] repo = br.readLine().split(" ");
            w[i] = Integer.parseInt(repo[0]);
            v[i] = Integer.parseInt(repo[1]);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                if (w[i] > j) {
                    mem[i][j] = mem[i - 1][j];
                } else {
                    mem[i][j] = Math.max(mem[i - 1][j], mem[i - 1][j - w[i]] + v[i]);
                }
            }
        }

        System.out.println(mem[n][k]);
    }
}
