package 프로그래머스_11장_자주등장하는자료구조;

/**
 <문제풀이흐름>
 A선수가 B선수를 이겼다 -> 방향 그래프
 선수 수가 100명 이하이다 -> 인접 행렬 방식 구현
 한 선수의 경기 결과: (이긴 선수 들의 수 + 진 서수들의 수) + 1 이 전체선수인가?
 정점[이사람이 이김][이사람이 짐]
 **/
public class 순위_Level3 {
    public int solution(int n, int[][] results) {
        //입력 데이터를 이용한 그래프
        boolean[][] graph = new boolean[n][n];
        for(int[] edge : results) {
            int u = edge[0] - 1;
            int v = edge[1] - 1;
            graph[u][v] = true;
        }

        int count = 0;
        for(int u = 0; u < n; u++) {
            int wins = winningCount(u, graph, new boolean[n]) - 1;
            int losses = losingCount(u, graph, new boolean[n]) - 1;
            if(wins + losses + 1 == n) {
                count++;
            }
        }

        return count;
    }
    /**
     u: 진행을 시작할 정점
     isVisited: -> 재방문 방지
     **/
    private int winningCount(int u, boolean[][]graph, boolean[] isVisited) {
        int count = 1;
        for(int v = 0; v < graph[u].length; v++) {
            //진행할 수 없는경우
            if(!graph[u][v] || isVisited[v]) continue;

            isVisited[v] = true;
            count += winningCount(v, graph, isVisited);
        }
        return count;
    }
    private int losingCount(int u, boolean[][]graph, boolean[] isVisited) {
        int count = 1;

        for(int v = 0; v < graph.length; v++) {
            //진행할 수 없는경우
            if(!graph[v][u] || isVisited[v]) continue;

            isVisited[v] = true;
            count += losingCount(v, graph, isVisited);
        }
        return count;
    }
}
