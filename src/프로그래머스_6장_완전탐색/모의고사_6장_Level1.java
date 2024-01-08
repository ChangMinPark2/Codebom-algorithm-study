package 프로그래머스_6장_완전탐색;
import java.util.*;

public class 모의고사_6장_Level1 {
    public int[] solution(int[] answers) {
        int[] one = {1, 2, 3, 4, 5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] answer = new int[3];

        for(int i = 0; i < answers.length; i++){
            if(answers[i] == one[i % 5]) answer[0]++;
            if(answers[i] == two[i % two.length]) answer[1]++;
            if(answers[i] == three[i % three.length]) answer[2]++;
        }

        int max = Math.max(answer[0], Math.max(answer[1], answer[2]));

        List<Integer> list = new ArrayList<>();

        if(max == answer[0]) list.add(1);
        if(max == answer[1]) list.add(2);
        if(max == answer[2]) list.add(3);

        return list.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
