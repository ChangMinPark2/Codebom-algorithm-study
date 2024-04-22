package 코드봄_level2;

public class Level2_방문길이 {
	public int solution(String dirs) {
		boolean[][][][] visited = new boolean[11][11][11][11];
		int count = 0;
		int x = 5;
		int y = 5;

		for (char dir : dirs.toCharArray()) {
			int nx = x;
			int ny = y;

			if (dir == 'U') ny--;
			if (dir == 'D') ny++;
			if (dir == 'L') nx--;
			if (dir == 'R') nx++;
			if (isCheck(nx, ny)) {
				if (!visited[y][x][ny][nx]) {
					visited[y][x][ny][nx] = visited[ny][nx][y][x] = true;
					count++;
				}

				x = nx;
				y = ny;
			}
		}

		return count;
	}
	boolean isCheck(int x, int y) {
		return x >= 0 && x <= 10 && y >= 0 && y <= 10;
	}
}
