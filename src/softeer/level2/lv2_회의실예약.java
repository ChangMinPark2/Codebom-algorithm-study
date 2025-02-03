package softeer.level2;

import java.io.*;
import java.util.*;

public class lv2_회의실예약 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");
        int n = Integer.parseInt(temp[0]);  // 회의실 개수
        int m = Integer.parseInt(temp[1]);  // 예약 개수
        String[] rooms = new String[n];

        int[][] arr = new int[n][19];

        // 회의실 입력받기
        for (int i = 0; i < n; i++) {
            rooms[i] = br.readLine();
        }

        // 회의실 정렬
        Arrays.sort(rooms);

        // 회의실 이름을 인덱스로 매핑
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(rooms[i], i);
        }

        // 예약 정보 저장
        for (int i = 0; i < m; i++) {
            temp = br.readLine().split(" ");
            int index = map.get(temp[0]);
            int start = Integer.parseInt(temp[1]);
            int end = Integer.parseInt(temp[2]);

            for (int j = start; j < end; j++) {  // end는 포함되지 않음
                arr[index][j] = 1;
            }
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append("Room ").append(rooms[i]).append(":\n");

            List<String> availableTimes = new ArrayList<>();
            int start = -1;

            for (int j = 9; j <= 17; j++) {
                if (arr[i][j] == 0 && start == -1) {  // 예약이 안된 시간 발견 (새로운 시작)
                    start = j;
                } else if (arr[i][j] == 1 && start != -1) {  // 예약된 시간 발견 (이전 구간 종료)
                    availableTimes.add(String.format("%02d-%02d", start, j));
                    start = -1;
                }
            }

            // 마지막 구간 확인 (17시까지 예약이 없었다면 종료 추가)
            if (start != -1) {
                availableTimes.add(String.format("%02d-18", start));
            }

            if (availableTimes.isEmpty()) {
                sb.append("Not available\n");
            } else {
                sb.append(availableTimes.size()).append(" available:\n");
                for (String time : availableTimes) {
                    sb.append(time).append("\n");
                }
            }

            if(i != n - 1) {
                sb.append("-----\n");
            }
        }

        System.out.println(sb);
    }
}
