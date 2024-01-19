package 프로그래머스_11장_자주등장하는자료구조;
import java.util.*;

public class 이중우선순위큐 {
    public int[] solution(String[] operations) {
        DoublePriorityQueue dpq = new DoublePriorityQueue();

        for (String str : operations) {
            String[] repo = str.split(" ");
            String command = repo[0];
            String value = repo[1];
            if (command.equals("I")) dpq.add(Integer.parseInt(value));
            if (command.equals("D")) {
                if (value.equals("1")) {
                    dpq.removeMax();
                } else {
                    dpq.removeMin();
                }
            }
        }

        return new int[] {dpq.max(), dpq.min()};
    }

    private static class DoublePriorityQueue {
        private int size = 0;
        private final PriorityQueue<Integer> minPq = new PriorityQueue<>();
        private final PriorityQueue<Integer> maxPq = new PriorityQueue<>((o1, o2) -> o2 - o1);

        public void add(int value) {
            minPq.add(value);
            maxPq.add(value);
            size++;
        }

        public void removeMax() {
            if (size == 0) return;
            maxPq.remove();
            if (--size == 0) {
                maxPq.clear();
                minPq.clear();
            }
        }
        public void removeMin() {
            if (size == 0) return;
            minPq.remove();
            if (--size == 0) {
                maxPq.clear();
                minPq.clear();
            }
        }

        public int max() {
            if (size == 0) return 0;
            return maxPq.peek();
        }

        public int min() {
            if (size == 0) return 0;
            return minPq.peek();
        }
    }

}
