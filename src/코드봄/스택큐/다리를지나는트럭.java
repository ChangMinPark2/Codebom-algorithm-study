package 코드봄.스택큐;
/**
 * <문제풀이흐름>
 * 다리를 순서대로 지나는데 걸리는 최소한의 시간. (다리의 길이, 무게를 고려하여)
 * 시간이 흐르는 경우 -> 다리 위에 올라가거나, 전진하거나.
 * 조건 -> 다리 위 트럭의 무게 + 트럭의 무게 <= 제한무게
 * 조건이 맞으면 q의 트럭 삽입 후 index++, 올라가지 못하면 다리 위에 있는 트럭이 전진 -> q의 0 삽입
 **/

import java.util.*;

public class 다리를지나는트럭 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Deque<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < bridge_length; i++) {
            q.add(0);
        }
        int count = 0;
        int nowBridgeWeight = 0;
        int index = 0;

        while (index < truck_weights.length) {
            nowBridgeWeight -= q.remove();
            int truck = truck_weights[index];

            if (truck + nowBridgeWeight <= weight) {
                index++;
                q.add(truck);
                nowBridgeWeight += truck;
            } else { //다리에 트럭이 올라가진 못했지만, 다리 위에 있는 트럭은 전진한다.
                q.add(0);
            }
            count++;
        }

        while (nowBridgeWeight > 0) {
            nowBridgeWeight -= q.remove();
            count++;
        }

        return count;
    }
}
