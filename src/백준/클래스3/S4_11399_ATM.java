package 백준.클래스3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * N: 1000 (딱히 안 떠오름) 20, 500, 10만
 * 3, 1, 4, 3, 2
 * 25143 -> 12334
 */

public class S4_11399_ATM {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();

        int answer = 0;

        for (int i = 0; i < n; i++) {
            int temp = 0;

            for (int j = 0; j <= i; j++) {
                temp += arr[j];
            }
            answer += temp;
        }

        System.out.println(answer);
    }
}
