package 백준.그리디;
import java.util.*;
import java.io.*;
public class S4_동전0 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(br.readLine());

            if (a <= k) {
                list.add(a);
            }
        }

        Collections.sort(list, ((o1, o2) -> o2 - o1));
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            if (k - list.get(i) >= 0) {
                int standard = k / list.get(i);
                k = k - (standard * list.get(i));
                count += standard;
            }
            if (k == 0) break;
        }

        System.out.println(count);
    }
}
