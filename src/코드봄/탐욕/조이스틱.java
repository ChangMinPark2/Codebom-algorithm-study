package 코드봄.탐욕;

import java.util.*;

/**
 * 맨 처음엔 A로 시작한다.
 * 상 -> 다음 알파벳
 * 하 -> 이전 알파벳
 * 좌 -> 커서를 왼쪽으로 이동 (인덱스를 왼쪽으로 이동 0이면 length - 1로.) c - 'A'
 * 우 -> 커서를 오른쪽으로 이동 (인덱스를 오른쪽 length - 1이면 0으로) 'Z' - c + 1
 * <문제풀이조건>
 * 최솟값 구하는 문제
 * <위, 아래> name을 순회하여 위 아래 중 구할 수 있는 최솟값 += 한다.
 * <좌, 우> 오른쪽으로 쭉 가기. 왼쪽 갔다가 오른쪽으로 가기. 오른쪽 갔다가 왼쪽 가기.
 **/

public class 조이스틱 {
    static int count;

    public static int solution(String name) {
        for (char c : name.toCharArray()) {
            bfs(c);
        }

        int min = name.length() - 1;

        for (int i = 0; i < name.length(); i++) {
            if (i < name.length() - 1 && name.charAt(i + 1) == 'A') {
                int endA = i + 1;
                while (endA < name.length() && name.charAt(endA) == 'A')
                    endA++;

                //BAAABBB
                min = Math.min(min, i * 2 + (name.length() - endA));// 오른쪽으로 갔다 다시 왼쪽으로 꺾기
                min = Math.min(min, i + (name.length() - endA) * 2);// 왼쪽으로 갔다 다시 오른쪽으로 꺾기
            }
        }

        return min + count;
    }

    static void bfs(char c) {
        Queue<UpDown> q = new LinkedList<>();
        q.add(new UpDown('A', 0));

        while (!q.isEmpty()) {
            UpDown a = q.remove();

            if (a.c == c) {
                count += a.i;
                System.out.println(a.i + " 상하 최솟값");
                break;
            }

            char nextChar = (char) ((a.c - 'A' + 1) % 26 + 'A');
            char prevChar = (char) ((a.c - 'A' - 1) % 26 + 'A');

            q.add(new UpDown((char) (nextChar), a.i + 1));
            q.add(new UpDown((char) (prevChar), a.i + 1));
        }

    }

    public static class UpDown {
        char c;
        int i;

        public UpDown(char oc, int oi) {
            this.c = oc;
            this.i = oi;
        }
    }

    public static int solution2(String name) {
        int answer = 0;
        int size = name.length();

        int move = size - 1;    // 오른쪽

        for (int i = 0; i < name.length(); i++) {
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1); //상,하 알파벳 맞추기

            int endA = i + 1;

            while (endA < name.length() && name.charAt(endA) == 'A')
                endA++;

            System.out.println(endA + "<- endA " + i + " i의 값입니다. " + (i * 2 + (name.length() - endA)));
            move = Math.min(move, i * 2 + (name.length() - endA));// 오른쪽으로  i만큼 갔다가 다시 왼쪽으로 꺾기
            move = Math.min(move, i + (name.length() - endA) * 2);// 왼쪽으로 갔다 다시 오른쪽으로 꺾기

        }
        // 상하 변경 횟수 + 좌우 이동 횟수
        return answer + move;
    }

    public static void main(String[] args) {
        System.out.println(91 % 91);
        System.out.println(solution("BBAAAB"));
    }
}
