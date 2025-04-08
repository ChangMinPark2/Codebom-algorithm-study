package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class S4_13900 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        long sum = Arrays.stream(arr).asLongStream().sum();
        long answer = 0;

        for (int i = 0; i < n; i++) {
            sum -= arr[i];
            answer += (long) arr[i] * sum;
        }

        System.out.println(answer);
    }
}
