package 코드봄.디피;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Level3_N으로표현 {
    public static int solution(int N, int number) {
        List<Set<Integer>> mem = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            mem.add(new HashSet<>());
        }

        for (int i = 0; i < 8; i++) {
            mem.get(i).add(Integer.parseInt(Integer.toString(N).repeat(i + 1)));
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < i; j++) {
                for (int k : mem.get(j)) {
                    for (int l : mem.get(i - j - 1)) {
                        mem.get(i).add(k + l);
                        mem.get(i).add(k - l);
                        mem.get(i).add(k * l);
                        if (l != 0) {
                            mem.get(i).add(k / l);
                        }
                    }
                }
            }
        }

        int answer = -1;

        for (int i = 0; i < 8; i++) {
            if (mem.get(i).contains(number)) {
                answer = i + 1;
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(5, 12));
    }
}
