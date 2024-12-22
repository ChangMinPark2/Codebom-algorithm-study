package 백준.클래스3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * n -> 10만 (정렬 가능)
 *
 * 메모장에는 사이트의 주소와 비밀번호.
 * 비밀번호를 찾는 프로그램을 만들기.
 *
 * 사이트의 주소와, 비밀번호가 주어진다.
 * ? 개쉬움
 */
public class S4_17219_비밀번호찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] repo = br.readLine().split(" ");

        int n = Integer.parseInt(repo[0]);
        int m = Integer.parseInt(repo[1]);

        Map<String, String> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String[] repo2 = br.readLine().split(" ");
            map.put(repo2[0], repo2[1]);
        }

        for (int i = 0; i < m; i++) {
            String site = br.readLine();
            sb.append(map.get(site)).append("\n");
        }

        System.out.println(sb);
    }
}
