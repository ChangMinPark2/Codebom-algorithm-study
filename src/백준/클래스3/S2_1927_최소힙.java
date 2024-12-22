package 백준.클래스3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * n이 10만, 시간제한 1초 : 정렬
 *
 * 1. 배열에 자연수 x를 넣는다.
 * 2. 가장 작은 값을 출력하고, 그 값을 배열에서 제거한다
 * 0이면 제거후 출력해라
 *
 */
public class S2_1927_최소힙 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Long> pq = new PriorityQueue<>();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            long x = Integer.parseInt(br.readLine());

            if (x == 0) {
                if (pq.isEmpty()) {
                    sb.append(0).append("\n");
                    continue;
                }
                sb.append(pq.remove()).append("\n");
            } else pq.add(x);
        }

        System.out.println(sb);
    }
}
