package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1_1157_단어공부re {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().toUpperCase();
        int[] arr = new int[26]; // 0 = A 인셈.

        for (int i = 0; i < s.length(); i++) {
            int stand = s.charAt(i) - 'A'; //A일 경우 0
            arr[stand]++;
        }

        int max = -1;
        char answer = ' ';

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) { //큰 경우만 덮어 씌우고
                max = arr[i];
                answer = (char) (i + 'A'); //정답
            } else if (arr[i] == max) {
                answer = '?';
            }
        }

        System.out.println(answer);
    }
}
