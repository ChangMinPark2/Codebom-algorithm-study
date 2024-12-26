package 백준.클래스3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * N: 10만, 정렬
 * 절댓값이 가장 작은 값을 출력하고, 절댓값이 가장 작은 값이 여러개일 경우, 가장 작은 수를 출력하고 제거한다.
 *
 */
public class S1_11286_절댓값힙 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            if (Math.abs(o1) == Math.abs(o2)) {
                return o1 - o2;
            } else {
                return Math.abs(o1) - Math.abs(o2);
            }
        });

        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(br.readLine());
            if (temp == 0) {
                if (!pq.isEmpty()) {
                    System.out.println(pq.remove());
                    continue;
                }
                System.out.println(0);
                continue;
            }
            pq.add(temp);
        }
    }
}
