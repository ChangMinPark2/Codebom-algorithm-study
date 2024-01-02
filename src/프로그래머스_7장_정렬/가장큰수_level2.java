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
                .replaceAll("^0+", "0");
    }
}
