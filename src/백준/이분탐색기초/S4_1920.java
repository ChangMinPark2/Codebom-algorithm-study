package 백준.이분탐색기초;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class S4_1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();
        int m = Integer.parseInt(br.readLine());
        int[] test = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < m; i++) {
            System.out.println(binarySearch(test[i], n, arr));
        }
    }

    private static int binarySearch(int stand, int n, int[] arr) {
        int left = 0;
        int right = n - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (stand > arr[mid]) { // 중간보다 오른쪽이라면
                left = mid + 1; //왼쪽 제거
            } else if (stand < arr[mid]) { //중간보다 왼쪽이라면
                right = mid - 1; //오른똑 제거
            } else return 1;
        }
        return 0;
    }
}
