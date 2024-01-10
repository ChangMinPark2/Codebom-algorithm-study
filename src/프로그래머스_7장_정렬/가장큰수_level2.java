package 프로그래머스_7장_정렬;

import java.util.Arrays;
import java.util.stream.Collectors;

public class 가장큰수_level2 {
    public String solution(int[] numbers) {
        return Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .sorted((o1, o2) -> {
                    int origin = Integer.parseInt(o1 + o2);
                    int reverse = Integer.parseInt(o2 + o1);

                    return reverse - origin;
                })
                .collect(Collectors.joining(""))
                .replaceAll("^0+", "0"); // {0, 0, 0} 일 경우 -> 0으로 치환해해준다
    }

    public String solution2(int[] numbers) {
        String answer = Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .sorted((o1,o2) -> {
                    int origin = Integer.parseInt(o1 + o2);
                    int after = Integer.parseInt(o2 + o1);
                    return after - origin;
                })
                .collect(Collectors.joining(""));

        answer = answer.replaceAll("^0+", "0");

        return answer;
    }
}
