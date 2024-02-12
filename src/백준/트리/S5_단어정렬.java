package 백준.트리;

import java.io.*;
import java.util.*;

public class S5_단어정렬 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<String> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.length() == o2.length()) {
                return o1.compareTo(o2);
            }
            return o1.length() - o2.length();
        });

        for (int i = 0; i < n; i++) {
            String repo = br.readLine();
            if (!pq.contains(repo)) {
                pq.add(repo);
            }
        }

        while (!pq.isEmpty()) {
            System.out.println(pq.remove());
        }
    }
}
