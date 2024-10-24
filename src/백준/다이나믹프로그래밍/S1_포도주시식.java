package 백준.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 포도주를 선택하면 무조건 다 먹고 원래 자리로 위치시키기
 * 연속으로 3잔은 못 마신다.
 * 각 포도주 잔에 들어있는 포도주의 양이 주어질 때, 가장 많은 양을 마시기
 * n = 10000
 */
public class S1_포도주시식 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int[] mem = new int[n];

        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(br.readLine());
            arr[i] = temp;
        }

        mem[0] = arr[0];

        for (int i = 1; i < n; i++) {
            if (i == 1) {
                mem[1] = arr[0] + arr[1];
                continue;
            }
            if (i == 2) {
                mem[2] = Math.max(mem[1], Math.max(arr[0] + arr[2], arr[1] + arr[2]));
                continue;
            }
            mem[i] = Math.max(mem[i - 1], Math.max(mem[i - 2] + arr[i], mem[i - 3] + arr[i - 1] + arr[i]));
        }

        System.out.println(mem[n - 1]);
    }
}
