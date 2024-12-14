package PCCP;

/**
 난이도 : diff
 소요시간 : time_cur
 이전 퍼즐의 소요 시간 : time_prev
 숙련도 level

 난이도가 숙련도보다 작거나 같다면, 소요시간 사용해 해결
 난이도가 높다면 (난이도 - 숙련도) 번 틀린다.
 이후, 이전 퍼즐의 소요시간 만큼을 사용해 이전 퍼즐을 다시 풀고 와야한다.
 풀고 오면, 난이도에 상관없이 틀리지 않는다.
 난이도 - 숙련도번 틀린 이후에 다시 퍼즐을 풀면, 소요시간을 사용해 퍼즐 해결

 제한 시간 내에 퍼즐을 모두 해결하기 위한 숙련도의 최솟값을 구하는 문제.
 **/

public class 기출문제_2_퍼즐게임첼린지 {
    public int solution(int[] diffs, int[] times, long limit) {
        return binarySearch(diffs, times, limit);
    }

    private int binarySearch(int[] diffs, int[] times, long limit) {
        int max = 1;
        int min = 100000;

        while(max <= min) {
            int level = (max + min) / 2;
            long mid = calculator(diffs, times, level);

            if(mid > limit) max = level + 1;
            else min = level - 1;
        }

        return max;
    }

    private long calculator(int[] diffs, int[] times, int level) {
        long answer = 0;

        for(int i = 0; i < diffs.length; i++) {
            if(diffs[i] <= level) {
                answer += times[i];
            } else {
                answer += (long) (times[i] + times[i - 1]) * (long)(diffs[i] - level) + times[i];
            }
        }

        return answer;
    }
}
