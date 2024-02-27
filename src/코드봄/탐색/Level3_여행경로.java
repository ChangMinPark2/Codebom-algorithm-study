package 코드봄.탐색;
import java.util.*;

public class Level3_여행경로 {
    private static boolean[] visited; // 방문한지 안한지를 체크하는 visited 배열
    private static List<String> result = new ArrayList<>();

    public static String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        dfs(0, "ICN", "ICN", tickets);
        Collections.sort(result);

        String[] answer = result.get(0).split(" ");

        return answer;
    }

    public static void dfs(int idx, String start, String route, String[][] tickets) {
        if (idx == tickets.length) {
            result.add(route);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i][0].equals(start) && !visited[i]) {
                visited[i] = true;
                dfs(idx + 1, tickets[i][1], route + " " + tickets[i][1], tickets);
                visited[i] = false;
            }
        }
    }
    public static void main(String[] args) {
        String[][] a = {
                {"ICN", "SFO"},
                {"ICN", "ATL"},
                {"SFO", "ATL"},
                {"ATL", "ICN"},
                {"ATL","SFO"}
        };
        System.out.println(Arrays.toString(solution(a)));
    }
}


