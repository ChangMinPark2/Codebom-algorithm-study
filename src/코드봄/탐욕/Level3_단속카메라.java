package 코드봄.탐욕;
import java.util.*;

public class Level3_단속카메라 {
    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes, ((o1, o2) -> o1[1] - o2[1]));

        int min = Integer.MIN_VALUE;

        for(int[] route : routes) {
            //마지막에 설치된 카메라가 다음 차량의 시작지점보다 작으면, 새로운 카메라를 설치해야 한다.
            if(min < route[0]) {
                min = route[1];
                answer++;
            }
        }

        return answer;
    }

}
