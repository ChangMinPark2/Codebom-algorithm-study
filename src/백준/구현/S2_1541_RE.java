package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 55-50+40
 */
public class S2_1541_RE {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split("-");
        int answer = 0;

        for (int i = 0; i < str.length; i++) {
            int temp = 0;
            String[] str2 = str[i].split("\\+");

            for (int j = 0; j < str2.length; j++) {
                temp += Integer.parseInt(str2[j]);
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
