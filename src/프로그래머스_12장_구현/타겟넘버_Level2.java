package 프로그래머스_12장_구현;

/**
 * <문제풀이흐름>
 * n개의 음이 아닌 정수를 활용하여 순서는 바꾸지 않고 더하거나 뺴서 타겟 넘버를 만드는 수.
 * 이미 정해진 값에서 탐색만 진행하는 것이므로 탐색 코드만 작성하면 된다.
 * result -> 정점 값
 */
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

