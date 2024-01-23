package 프로그래머스_12장_구현;

/**
<문제풀이흐름>
제시해준 배열의 순서를 바꾸지 않고 + - 했을때 target이 나오는 수를 리턴.
값을 제시해줬으므로 탐색만 진행하면 된다.(그래프를 만들 필요가 없다.) -> dfs.(최단 경로가 아니다.)
**/
public class 타겟넘버_Level2 {
    int answer = 0;
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return answer;
    }

    public void dfs (int[] numbers, int target, int depth, int result) {
        if (depth == numbers.length) {
            if (target == result) answer++;
            return;
        }

        dfs(numbers, target, depth + 1, result + numbers[depth]);
        dfs(numbers, target, depth + 1, result - numbers[depth]);
    }
}

