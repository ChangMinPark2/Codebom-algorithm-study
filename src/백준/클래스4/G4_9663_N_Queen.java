package 백준.클래스4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G4_9663_N_Queen {
    static int[] arr;
    static int n;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n]; // 인덱스 y축, 값 x축
        back(0);
        System.out.println(answer);
    }

    private static void back(int depth) {
        if (depth == n) {
            answer++;
            return;
        }

        for (int i = 0; i < n; i++) {
            arr[depth] = i;

            if (isCheck(depth)) {
                back(depth+ 1);
            }
        }
    }

    private static boolean isCheck(int y) {
        for (int i = 0; i < y; i++) {
            if (arr[y] == arr[i]) {
                return false;
            } else if (Math.abs(y - i) == Math.abs(arr[y] - arr[i])) {
                return false;
            }
        }

        return true;
    }
}
