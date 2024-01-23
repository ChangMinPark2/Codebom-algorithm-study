package 프로그래머스_12장_구현;
/**
 학생들의 번호는 체격순. +1 -1 만 빌려줄 수 있다. 적절히 빌려 최대한 많은 학생이 수업을 듣는 값 구하기.
 n은 학생의 수, lost는 도난당한 학생들의 번호, reserve는 여벌의 체육복을 가져온 학생들.
 중복은 없다. reserve와 lost 둘다 있는 학생은 빌려줄 수 없다 (자신 것을 입는다)

 <문제풀이 흐름>
 1. 배열들을 순서대로 순회하기 위하여 오름차순 정렬.
 2. 여벌 옷이 있고 도난 당한 학생들 부터 처리.
 **/
import java.util.*;
import java.util.stream.Collectors;
public class 체육복_Level1 {
    public int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(lost);
        Arrays.sort(reserve);

        Set<Integer> set = Arrays.stream(lost)
                .boxed()
                .collect(Collectors.toSet());

        set.retainAll(Arrays.stream(reserve)
                .boxed()
                .collect(Collectors.toSet()));

        Queue<Integer> q = new LinkedList<>();
        for(int i : lost) q.add(i);

        int answer = 0;
        for(int i : reserve) {
            if(set.contains(i)) continue;

            while(!q.isEmpty() && (q.peek() < i - 1 || set.contains(q.peek()))) {
                q.poll();
            }

            if(q.isEmpty()) break;

            if(q.peek() <= i + 1) {
                q.poll();
                answer++;
            }
        }

        return n - lost.length + set.size() + answer;
    }
}
