package 코드봄.탐색;
/**
 적절히 더하고 뺐을 때 target인 갯수를 구하는 문제.
 0을 부모로 트리형태로 dfs를 구했을 때 리프노드를 보면 되는 문제이다.

 <문제풀이흐름>
 1. dfs의 깊이 0, result 0 을 넣어서 다음 인덱스를 - + 한다. (초기값)
 2. depth가 == 리프노드의 깊이면 return (종료조건)
 3. 종료 조건일 때 result 가 target 이라면 ++한다.
 **/
public class Level2_타겟넘버 {
    int leaf, answer = 0;
    public int solution(int[] numbers, int target) {
        leaf = numbers.length;
        dfs(target, 0, 0, numbers);
        return answer;
    }

    void dfs(int target, int depth, int result, int[] numbers) {
        if(depth == leaf) {
            if(result == target) answer++;
            return;
        }
        dfs(target, depth + 1, result - numbers[depth], numbers);
        dfs(target, depth + 1, result + numbers[depth], numbers);
    }
}
