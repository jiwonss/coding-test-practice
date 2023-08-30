import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, result;
	static int[][] map;
	static int[] dx = {0, 1, 1}, dy = {1, 0, 1};

	private static void dfs(int x, int y, int d) {
		if (x == N - 1 && y == N - 1) {
			result++;
			return;
		}
		
		for (int i = 0; i < 3; i++) {
			if ((d == 0 && i == 1) || (d == 1 && i == 0)) continue;
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (!isMove(nx, ny, i)) continue;
			dfs(nx, ny, i);
		}
	}
	
	private static boolean isMove(int x, int y, int d) {
		if (x < 0 || x >= N || y < 0 || y >= N) return false;
		if ((d == 0 || d == 1) && map[x][y] != 0) return false;
		if (d == 2) {
			int nx = x - dx[d], ny = y - dy[d];
			if (nx + 1 >= N || ny + 1 >= N) return false;
			if (map[nx + 1][ny] != 0 || map[nx][ny + 1] != 0 || map[nx + 1][ny + 1] != 0) return false;		
		}	
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		result = 0;
		dfs(0, 1, 0);
		System.out.println(result);
	}

}
