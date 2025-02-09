package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class S2_11055 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int answer = 0;
        int[] mem = new int[n + 1];

        mem[0] = arr[0];

        for (int i = 1; i < n; i++) {
            mem[i] = arr[i];
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) { //증가 조건
                    mem[i] = Math.max(mem[i], arr[i] + mem[j]);
                }
            }

            answer = Math.max(mem[i], answer);
        }
        System.out.println(answer);
    }
}
