package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S5_1316_그룹단어체커 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int answer = 0;

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            boolean check = true;

            for (int j = 1; j < s.length(); j++) {
                if (s.charAt(j - 1) != s.charAt(j)) {
                    String temp = s.substring(0, j);
                    String stand = String.valueOf(s.charAt(j));

                    if (temp.contains(stand)) {
                        check = false;
                        break;
                    }
                }
            }

            if (check) answer++;
        }

        System.out.println(answer);
    }
}
