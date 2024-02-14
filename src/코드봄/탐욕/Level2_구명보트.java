package 코드봄.탐욕;
/**
 <문제풀이흐름>
 최솟값이 나오는 최선의 방법은 최댓값을 같이 보트로 태워 보내는 경우가 최선의 선택이다.
 1. 정렬 이후 최솟값 인덱스, 최댓값 인덱스를 구한다.
 2. min + max <= limit 이라면  min 사람과, max 사람이 같이 보트를 타고 건넌 경우이다. min++, max--, count++;
 3. 2번이 아니라면 max 사람만 보트를 타고 간 경우이다.
 **/
import java.util.*;
public class Level2_구명보트 {
    public static int solution2(int[] people, int limit) {
        Arrays.sort(people);
        int count = 0;
        int min = 0;
        int max = people.length - 1;

        while (min <= max) {
            if (people[min] + people[max] <= limit){
                count++;
                max--;
                min++;
            } else {
                count++;
                max--;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {70, 80, 50};
        int limit = 100;
        System.out.println(solution2(arr, limit));
    }
}
