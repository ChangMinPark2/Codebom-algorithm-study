package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class S4_2776 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] book1 = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .sorted()
                    .toArray();

            int m = Integer.parseInt(br.readLine());
            int[] book2 = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .sorted()
                    .toArray();

            for (int j : book2) {
                sb.append(binarySearch(n, book1, j));
            }
        }

        System.out.println(sb);
    }

    private static int binarySearch(int n, int[] ar, int target) {
        int left = 0;
        int right = n - 1;

        while (left <= right) {
            int mid = (left + right) / 2; //인덱스

            if (ar[mid] > target) { //타겟이 왼쪽이라면
                right = mid - 1;
            } else if (ar[mid] < target) {
                left = mid + 1;
            } else return 1;
        }

        return 0;
    }
}
