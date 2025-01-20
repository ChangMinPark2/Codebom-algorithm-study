package softeer.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class lv2_GPT식숫자비교 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            String[] temp = s.split("\\.");

            if (temp.length == 2) {
                arr[i][0] = Integer.parseInt(temp[0]);
                arr[i][1] = Integer.parseInt(temp[1]);
            } else {
                arr[i][0] = Integer.parseInt(s);
                arr[i][1] = -1;
            }
        }

        Arrays.sort(arr, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            } else {
                return o1[0] - o2[0];
            }
        });

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            if (arr[i][1] != -1) {
                sb.append(arr[i][0]).append(".").append(arr[i][1]);
            } else {
                sb.append(arr[i][0]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
