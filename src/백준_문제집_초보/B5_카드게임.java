package 백준_문제집_초보;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B5_카드게임 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;

        for (int i = 0; i < 5; i++) {
            int a = Integer.parseInt(br.readLine());
            answer += a;
        }

        System.out.println(answer);
    }
}
