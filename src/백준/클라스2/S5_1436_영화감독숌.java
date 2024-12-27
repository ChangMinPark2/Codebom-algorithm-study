package 백준.클라스2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * N <= 10000
 *
 * 종말의 수란, 어떤 수에 6이 적어도 3개 이상 들어가는 것.
 * 제일 작은 종말의 수는 666, 그 다음으로 1666, 2666
 * N번째 영화의 제목은 세상의 종말 (N번째로 작은 종말의 수)와 같다
 *
 * 6 5666
 * 7 6660
 * 8 6661
 * 9 6662 ~ 9
 */

public class S5_1436_영화감독숌 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int num = 666;
        int count = 1;

        while(count != n) {
            num++;
            if(String.valueOf(num).contains("666")) {
                count++;
            }
        }
        System.out.println(num);
    }

}
