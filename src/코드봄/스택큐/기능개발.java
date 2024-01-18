package 코드봄.스택큐;

/**
 <문제풀이흐름>
 배포일수는 올림수 -> (100 - 진행도) / 스피드 를 올림수로 넣는다.
 index를 통한 두개의 배열 접근.
 큐에다가는 인덱스를 넣어준다.
 우선 0번쨰 인덱스 만큼 지난거기 떄문에, 0 + 1 번쨰 인덱스랑 비교해주는 형식으로 진행한다.
 **/
import java.util.*;
public class 기능개발 {
    public static int[] solution(int[] progresses, int[] speeds) {
        Deque<Integer> q = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < progresses.length; i++) {
            q.add(i);
        }

        int count = 0;
        int day = 0;

        while(!q.isEmpty()) {
            int index = q.remove();
            int complete = (int) Math.ceil((double) (100 - progresses[index]) / speeds[index]);

            if(complete > day) {
                if(day != 0) {
                    list.add(count);
                    count = 0;
                }
                day = complete;
            }
            count++;
        }
        list.add(count);

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
    public static void main(String[] args) {
        //[93, 30, 55]	[1, 30, 5]
        int[] a = {93, 30, 55};
        int[] b = {1, 30, 5};
        System.out.println(solution(a, b));
    }
}
