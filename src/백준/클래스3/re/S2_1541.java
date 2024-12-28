package 백준.클래스3.re;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * N 제한사항 없음. 단순 구현
 *
 * - 기준으로 나눈다.
 */

import java.util.*;

public class S2_1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();
        int answer = 0;

        String[] repo = br.readLine().split("-");

        for (String s : repo) {
            if (s.contains("+")) {
                int temp = 0;
                String[] repo2 = s.split("\\+");

                for (String z : repo2) {
                    temp += Integer.parseInt(z);
                }

                list.add(temp);
            } else {
                list.add(Integer.parseInt(s));
            }
        }

        answer = list.get(0);

        for (int i = 1; i < list.size(); i++) {
            answer -= list.get(i);
        }

        System.out.println(answer);
    }
}
