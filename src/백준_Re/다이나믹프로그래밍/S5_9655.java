package 백준_Re.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1 또는 3 가능
 * n : 1 -> 상근
 * n : 2 -> 찬영
 * n : 3 -> 상근
 * n : 4 -> 찬영
 * n : 5 -> 상근
 * 홀짝?
 */
public class S5_9655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if (n % 2 == 1) {
            System.out.println("SK");
        } else {
            System.out.println("CY");
        }
    }
}
