package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S4_1748_수이어쓰기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        int plus = 1;
        int stand = 10;

        for (int i = 1; i <= n; i++) {
            if (i % stand == 0) {
                plus++;
                stand *= 10;
            }

            answer += plus;
        }
        System.out.println(answer);
    }
}
