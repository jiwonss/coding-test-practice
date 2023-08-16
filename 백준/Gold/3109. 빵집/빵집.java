import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static boolean check;
	static int R, C, result;
	static int[] dx = {-1, 0, 1}, dy = {1, 1, 1};
	static char[][] board;
	static int[][] visited;

	private static void dfs(int x, int y) {	
		if (y == C - 1) {
			result++;
			check = true;
			visited[x][y] = 1;
			return;
		}
		
		visited[x][y] = 1;
		for (int d = 0; d < 3; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
			if (visited[nx][ny] == 1 || board[nx][ny] != '.') continue;
			dfs(nx, ny);
			if (check) {
				return;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp;
		temp = br.readLine().split(" ");
		R = Integer.parseInt(temp[0]);
		C = Integer.parseInt(temp[1]);
	
		board = new char[R][C];
		for (int i = 0; i < R; i++) {
			temp = br.readLine().split("");
			for (int j = 0; j < C; j++) {
				board[i][j] = temp[j].charAt(0);
			}
		}
		
		result = 0;
		visited = new int[R][C];
		for (int i = 0; i < R; i++) {
			check = false;
			dfs(i, 0);
		}
		System.out.println(result);
	}

}
