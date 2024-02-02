package PCCE;
/**
 * 데이타 넘버, 제조일, 최대수량, 현재수량 순으로 작성된 data들 중에서
 * 어떤 데이터를 뽑는지에 대한 ext, val_ext 보다 작은 것들 중 sort_by 기준으로 오름차순 정렬해라.
 * ext, val_ext 기준에 맞는 것을 우선순위 큐에 넣는다.
 * 1. ext와 sort_by의 인덱스를 구한다.
 * 2. ext가 val_ext보다 작은 것만 넣는다.
 * 3. 우선 순위 큐를 sort_by 인덱스를 기준으로 오름차순한 것을 넣는다.
 **/

import java.util.*;

public class 데이터분석_10 {
    static int nSort;

    public static int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        String[] repo = {"code", "date", "maximum", "remain"};
        int nExt = 0;

        for (int i = 0; i < 4; i++) {
            if (repo[i].equals(ext)) nExt = i;
            if (repo[i].equals(sort_by)) nSort = i;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[nSort] - o2[nSort]);

        for (int[] arr : data) {
            if (arr[nExt] < val_ext) pq.add(arr);
        }

        int[][] result = new int[pq.size()][];
        int index = 0;

        while (!pq.isEmpty()) {
            result[index++] = pq.remove();
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] data = {
                {1, 20300104, 100, 80}, {2, 20300804, 847, 37}, {3, 20300401, 10, 8}
        };
        String ext = "date";
        int val = 20300501;
        String a = "remain";

        System.out.println(Arrays.deepToString(solution(data, ext, val, a)));
    }
}
