package 백준.클래스3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * N이 10, K가 10의 8승: 1억 (해시테이블, 이진검색, 수학구현)
 * 동전의 종류는 N, 종류별 합을 K로 만들기 동전의 개수를 최소화 하여.
 * 나눠진다면, 가장 큰 동전으로 선 결제
 */
public class S4_11047_동전0 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] repo = br.readLine().split(" ");
        int n = Integer.parseInt(repo[0]);
        int k = Integer.parseInt(repo[1]);
        int answer = 0;
        int[] arr = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            int temp = Integer.parseInt(br.readLine());
            arr[i] = temp;
        }

        for (int i = 0; i < n; i++) {
            if (k / arr[i] >= 1) {
                int temp = k / arr[i] * arr[i];
                answer += k / arr[i];
                k -= temp;

                if (k == 0) {
                    break;
                }
            }
        }

        System.out.println(answer);
    }
}
