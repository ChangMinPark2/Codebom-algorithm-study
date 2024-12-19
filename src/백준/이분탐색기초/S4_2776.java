package 백준.이분탐색기초;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class S4_2776 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .sorted()
                    .toArray();

            int m = Integer.parseInt(br.readLine());

            int[] target = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            for (int j = 0; j < m; j++) {
                sb.append(binarySearch(n, arr, target[j])).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static int binarySearch(int n, int[] arr, int target) {
        int left = 0;
        int right = n - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] > target) { // 타겟이 왼쪽이라면
                right = mid - 1;
            } else if (arr[mid] < target) { // 타겟이 오른쪽이라면
                left = mid + 1;
            } else return 1;
        }

        return 0;
    }
}
