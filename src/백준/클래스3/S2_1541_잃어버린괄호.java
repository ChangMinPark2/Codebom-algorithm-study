package 백준.클래스3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 입력으로 주어지는 식의 길이는 50보다 작거나 같다.
 * N <= 50 으로 봤을 때, 그래프 탐색 가능
 * + 와 - 괄호를 가지고 식을 만들었다. 이후 미웠다.
 * 괄호를 적절히 쳐서 이 식의 값을 최소로 만들기
 */
public class S2_1541_잃어버린괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] repo = br.readLine().split("-");

        int answer = 0;

        for (int i = 0; i < repo.length; i++) {
            int temp = 0;
            String[] repo2 = repo[i].split("\\+");

            for (int j = 0; j < repo2.length; j++) {
                temp += Integer.parseInt(repo2[j]);
            }

            if (i == 0) {
                answer = temp;
                continue;
            }

            answer -= temp;
        }

        System.out.println(answer);
    }
}
