package 코드봄.탐색;
/**
 * begin -> target으로 바꾸는 가장 짧은 젼환 과정.
 * 한 번에 한 개의 알파벳만 바꿀 수 있다.
 * words에 있는 단어로만 변환할 수 있다.
 * <문제풀이흐름>
 * 1. 문자열과, count 필드를 가지고 있는 클라스를 만들기
 * 2. 하나의 알파벳만 바꿀 수 있고, words의 문자열에 있는 단어로만 바꿀 수 있다.
 * isSizeCheck 메소드-> 문자열 두개의 각 인덱스를 비교하여, 같은 값이 size() - 1 이라면 true;
 * 모든 단어의 길이는 같으므로 가능하다.
 * 3. q에 begin을 넣고, words를 순회하며, charAt(i)가 같은지 비교해서 같은 값이 크기 - 1이라면,
 * 변환이 가능한 단어이므로, 큐에 해당 문자열을 넣고, count+1을 해서 넣는다.
 * q를 뺏을 때 target이라면 해당 값이 target이다.
 **/

import java.util.*;

public class Level3_단어변환 {
    boolean[] visited;
    Queue<Repo> q = new LinkedList<>();
    int answer = 0;

    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        q.add(new Repo(begin, 0, -1));
        bfs(words, target);
        return answer;
    }

    public void bfs(String[] words, String target) {
        while (!q.isEmpty()) {
            Repo repo = q.remove();
            if (repo.str.equals(target)) {
                answer = repo.count;
                break;
            }

            for (int i = 0; i < words.length; i++) {
                if (!visited[i] && isSizeCheck(repo.str, words[i])) {
                    q.add(new Repo(words[i], repo.count + 1, i));
                    visited[i] = true;
                }
            }
        }
    }

    public boolean isSizeCheck(String before, String target) {
        int count = 0;
        for (int i = 0; i < before.length(); i++) {
            if (before.charAt(i) == target.charAt(i)) {
                count++;
            }
        }
        return before.length() - 1 == count;
    }
}

class Repo {
    String str;
    int count;
    int index;

    public Repo(String str, int count, int index) {
        this.str = str;
        this.count = count;
        this.index = index;
    }
}
