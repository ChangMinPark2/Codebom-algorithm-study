package 백준.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1 ~ 10개
 * 2 1 1 1 1 1 1 1 1
 * 2 2 1 1 1 1 1 1
 * 2 2 2 1 1 1 1
 * 2 2 2 2 1 1
 * 2 2 2 2 2
 * 5 5
 * 5 1 1 1 1
 * 5 2 1 1 1
 * 5 2 2 1
 * 동전의 가치가 예제마다 다르므로, 규칙성은 없다.
 *
 */
public class G4_2293 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] repo = br.readLine().split(" ");
        int n = Integer.parseInt(repo[0]);
        int answer = Integer.parseInt(repo[1]);
        int[] arr = new int[n + 1];
        int[] mem = new int[answer + 1];
        mem[0] = 1;

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            for (int j = arr[i]; j <= answer; j++) {
                mem[j] += mem[j - arr[i]];
            }
        }

        System.out.println(mem[answer]);
    }
}
