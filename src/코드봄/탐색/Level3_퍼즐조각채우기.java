package 코드봄.탐색;

import java.util.*;


public class Level3_퍼즐조각채우기 {
    static List<List<Alpha>> game = new ArrayList<>();
    static List<List<Alpha>> user = new ArrayList<>();
    static boolean[][] gVisited;
    static boolean[][] tVisited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int size, answer;

    public static int solution(int[][] game_board, int[][] table) {
        size = game_board.length;
        gVisited = new boolean[size][size];
        tVisited = new boolean[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (game_board[i][j] == 1) game_board[i][j] = 0;
                else game_board[i][j] = 1;
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (!gVisited[i][j] && game_board[i][j] == 1) {
                    bfs(game_board, i, j, game, gVisited);
                }
                if (!tVisited[i][j] && table[i][j] == 1) {
                    bfs(table, i, j, user, tVisited);
                }
            }
        }

        startGame(game, user);

        return answer;
    }

    public static void bfs(int[][] standard, int y, int x, List<List<Alpha>> repo, boolean[][] visited) {
        Queue<Alpha> q = new LinkedList<>();
        visited[y][x] = true;
        q.add(new Alpha(x, y));

        List<Alpha> alphaList = new ArrayList<>();
        alphaList.add(new Alpha(0, 0));

        while (!q.isEmpty()) {
            Alpha alpha = q.remove();

            for (int i = 0; i < 4; i++) {
                int nx = alpha.x + dx[i];
                int ny = alpha.y + dy[i];

                if (isCheck(ny, nx, standard.length) && !visited[ny][nx] && standard[ny][nx] == 1) {
                    visited[ny][nx] = true;
                    q.add(new Alpha(nx, ny));
                    alphaList.add(new Alpha(nx - x, ny - y));
                }
            }
        }
        repo.add(alphaList);
    }

    static void startGame(List<List<Alpha>> game, List<List<Alpha>> user) {
        boolean[] userVisited = new boolean[user.size()];

        for (int i = 0; i < game.size(); i++) {
            List<Alpha> temp = game.get(i);

            for (int j = 0; j < user.size(); j++) {
                if (!userVisited[j] && temp.size() == user.get(j).size()) {
                    List<Alpha> userTemp = user.get(j);

                    if (isCheckAll(temp, userTemp)) {
                        answer += userTemp.size();
                        System.out.println(userTemp.size() + "->");
                        userVisited[j] = true;
                        break;
                    }
                }
            }
        }
    }

    static boolean isCheckAll(List<Alpha> game, List<Alpha> user) {
        Collections.sort(game, ((o1, o2) -> {
            if (o1.x == o2.x) return o1.y - o2.y;
            return o1.x - o2.x;
        }));

        for (int i = 0; i < 4; i++) {
            for (Alpha alpha : user) {
                int temp = alpha.x;
                alpha.x = -alpha.y;
                alpha.y = temp;
            }

            Collections.sort(user, ((o1, o2) -> {
                if (o1.x == o2.x) return o1.y - o2.y;
                return o1.x - o2.x;
            }));

            int dx = game.get(0).x - user.get(0).x;
            int dy = game.get(0).y - user.get(0).y;

            boolean match = true;

            for (int j = 0; j < game.size(); j++) {
                Alpha g = game.get(j);
                Alpha u = user.get(j);
                if (g.x != u.x + dx || g.y != u.y + dy) {
                    match = false;
                    break;
                }
            }

            if (match) return true;
        }

        return false;
    }


    static boolean isCheck(int y, int x, int max) {
        return y >= 0 && y < max && x >= 0 && x < max;
    }

    public static class Alpha {
        int x;
        int y;

        public Alpha(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    public static void main(String[] args) {
        int[][] game_board = {{1, 1, 0, 0, 1, 0}, {0, 0, 1, 0, 1, 0}, {0, 1, 1, 0, 0, 1}, {1, 1, 0, 1, 1, 1}, {1, 0, 0, 0, 1, 0}, {0, 1, 1, 1, 0, 0}};
        int[][] table = {{1, 0, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 0}, {0, 1, 1, 0, 1, 1}, {0, 0, 1, 0, 0, 0}, {1, 1, 0, 1, 1, 0}, {0, 1, 0, 0, 0, 0}};

        System.out.println(solution(game_board, table));
    }
}
