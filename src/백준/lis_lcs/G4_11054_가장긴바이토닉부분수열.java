package 백준.lis_lcs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class G4_11054_가장긴바이토닉부분수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] lMem = new int[n];
        int[] rMem = new int[n];

        for (int i = 0; i < n; i++) {
            lMem[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    lMem[i] = Math.max(lMem[i], lMem[j] + 1);
                }
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            rMem[i] = 1;
            for (int j = n - 1; j > i; j--) {
                if (arr[i] > arr[j]) {
                    rMem[i] = Math.max(rMem[i], rMem[j] + 1);
                }
            }
        }

        int answer = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            answer = Math.max(lMem[i] + rMem[i], answer);
        }

        System.out.println(answer - 1);
    }
}
