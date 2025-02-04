package 프로그래머스.lv1;

public class 덧칠하기 {
    public int solution(int n, int m, int[] section) {

        if(m == 1) {
            return section.length;
        }

        int start = section[0];
        int end = section[0] + m - 1;
        int answer = 1;

        for(int i : section) {
            if(i >= start && i <= end) {
                continue;
            } else {
                start = i;
                end = i + m - 1;
                answer++;
            }
        }

        return answer;
    }
}
