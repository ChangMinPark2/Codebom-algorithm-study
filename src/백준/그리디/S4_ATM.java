package 백준.그리디;
import java.util.*;
import java.io.*;
public class S4_ATM {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] repo = br.readLine().split(" ");

        int[] arr = Arrays.stream(repo)
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();

        int sum = 0;
        int total = 0;

        for (int i : arr) {
            sum = sum + i;
            total += sum;
        }

        System.out.println(total);
    }
}
