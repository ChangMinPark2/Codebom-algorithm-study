package 백준.클래스3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * n -> 30, 테스트케이스 100 -> 3000
 * 완탐 X 탐색도 불가능, 정렬 이상의 알고리즘 가능
 *
 * 패션에 매우 민감해서 한번 입었던 옷들의 조합을 다시 입지 않는다.
 * 프로그래머스 의상 문제랑 동일하다.
 * 안 입는 경우의 수를 위해 1부터 시작
 * 알몸인 상태는 없기에 마지막에 -1
 */
public class S3_9375_패션왕신해빈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());

            Map<String, Integer> map = new HashMap<>();

            for (int j = 0; j < n; j++) {
                String[] repo = br.readLine().split(" ");
                map.put(repo[1], map.getOrDefault(repo[1], 1) + 1);
            }

            int answer = 1;

            for (String key : map.keySet()) {
                answer *= map.get(key);
            }

            sb.append(answer - 1).append("\n");
        }

        System.out.println(sb);
    }
}
