package 프로그래머스_12장_구현;

import java.util.Arrays;
import java.util.stream.Collectors;
/**
 <문제풀이흐름> 왼손으로 누르냐 오른손으로 누르냐를 순서대로 리턴하는 문제.
 숫자는 (n-1) % 3 으로 배열로 구할 수 있다.
 가운데 위치한 숫자들의 경우 거리를 통해 결정한다. (같을 경우 왼손잡이냐 오른손 잡이냐를 따진다.)
 **/

public class 키패드누르기_Level1 {
    public String solution(int[] numbers, String hand) {
        Hand right = new Hand("R", hand.equals("right"), 2);
        Hand left = new Hand("L", hand.equals("left"), 0);

        return Arrays.stream(numbers)
                .mapToObj(o -> press(o, right, left).hand)
                .collect(Collectors.joining());
    }

    private int getX(int n) {
        if (n == 0) return 1;
        return (n - 1) % 3;
    }

    private int getY(int n) {
        if (n == 0) return 3;
        return (n - 1) / 3;
    }

    private Hand press(int number, Hand right, Hand left) {
        int x = getX(number);
        int y = getY(number);
        float rDistance = right.distance(x, y);
        float lDistance = left.distance(x, y);

        Hand hand = rDistance > lDistance ? right : left;
        hand.move(x, y);

        return hand;
    }

    private static class Hand {
        private final int baseX; //해당 손만 담당하는 x컴마.
        public final String hand; // 어느손잡이인지.
        private final float preference; //
        private int x;
        private int y;

        public Hand(String hand, boolean isPreference, int x) {
            this.hand = hand;
            this.baseX = x;
            this.preference = isPreference ? 0.5f : 0;
            this.x = x;
            this.y = 3;
        }

        public float distance(int x, int y) {
            if (x == baseX) return 0;
            int distance = Math.abs(x - this.x) + Math.abs(y - this.y);
            return distance - this.preference;
        }

        public void move(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}


