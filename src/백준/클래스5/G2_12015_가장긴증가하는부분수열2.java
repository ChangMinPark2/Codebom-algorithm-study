package 백준.클래스5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class G2_12015_가장긴증가하는부분수열2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] mem = new int[n];

        for (int i = 0; i < n; i++) {
            mem[i] = 1;

            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    mem[i] = Math.max(mem[i], mem[j] + 1);
                }
            }
        }

        Arrays.sort(mem);

        System.out.println(mem[n-1]);
    }
}
