package 백준.그리디;

import java.io.*;
public class B2_거스름돈 {
    static int count = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int left = 1000 - Integer.parseInt(br.readLine());
        int[] arr = {500, 100, 50, 10, 5, 1};

        int index = 0;

        while (left != 0) {
            while (arr[index % 6] <= left) {
                left -= arr[index % 6];
                count++;
            }
            index++;
        }

        System.out.println(count);
    }
}
