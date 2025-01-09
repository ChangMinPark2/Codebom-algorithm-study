package 백준.클래스5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class P5_14003_가장긴증가하는부분수열5 {
    static int[] lis;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] repo = br.readLine().split(" ");
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(repo[i]);
        }
        int[] mem = new int[n];
        lis = new int[n + 1];

        lis[0] = Integer.MIN_VALUE;

        int length = 0;
        int index = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] > lis[length]) {
                mem[i] = ++length;
                lis[length] = arr[i];
            } else {
                index = binarySearch(0, length, arr[i]);
                lis[index] = arr[i];
                mem[i] = index;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(length).append("\n");

        Deque<Integer> s = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i--) {
            if (mem[i] == length) {
                s.push(arr[i]);
                length--;
            }
        }

        while (!s.isEmpty()) {
            sb.append(s.pop()).append(" ");
        }
        System.out.println(sb.toString());
    }
    private static int binarySearch(int left, int right, int key) {
        int mid = 0;

        while (left < right) {
            mid = (left + right) / 2;

            if (lis[mid] < key) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return right;
    }
}
