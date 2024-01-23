package 프로그래머스;

import java.util.*;
public class 최솟값만들기 {

    //첫 번째 풀이 방법 -> 효율성에서 틀림.
    public int solution(int []A, int []B)
    {
        int answer = 0;

       Arrays.sort(A);

       Integer[] b = Arrays.stream(B)
               .boxed()
               .sorted((o1, o2) -> o2 - o1)
               .toArray(Integer[]::new);

        for (int i = 0; i < A.length; i++) {
            answer += A[i] * b[i];
        }

        return answer;
    }

    public int solution2(int []A, int []B)
    {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        for(int i = 0; i < A.length; i++) {
            answer += A[i] * B[B.length - i - 1];
        }
        return answer;
    }
}
