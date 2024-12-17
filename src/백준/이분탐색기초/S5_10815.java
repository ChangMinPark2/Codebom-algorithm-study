package 백준.이분탐색기초;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class S5_10815 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] card = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();
        int m = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            sb.append(binarySearch(arr[i], n, card)).append(" ");
        }

        System.out.println(sb);
    }

    private static int binarySearch(int stand, int n, int[] card) {
        int left = 0;
        int right = n - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int midValue = card[mid];

            if (stand > midValue) {
                left = mid + 1;
            } else if (stand < midValue) {
                right = mid - 1;
            } else return 1;
        }
        return 0;
    }
}
