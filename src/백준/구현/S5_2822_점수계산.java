package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class S5_2822_점수계산 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[8];
        int[] temp = new int[8];

        for (int i = 0; i < 8; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            temp[i] = arr[i];
        }

        Arrays.sort(temp);

        int answer = 0;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            answer += temp[7 - i];

            for (int j = 0; j < 8; j++) {
                if (temp[7 - i] == arr[j]) {
                    list.add(j + 1);
                    break;
                }
            }
        }

        Collections.sort(list);
        StringBuilder sb = new StringBuilder();

        sb.append(answer).append("\n");

        for (int i : list) {
            sb.append(i).append(" ");
        }

        System.out.println(sb);
    }
}
