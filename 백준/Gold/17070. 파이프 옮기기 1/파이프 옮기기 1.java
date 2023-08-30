import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, result;
	static int[][] status;
	static int[] dx = {0, 1, 1}, dy = {1, 0, 1};

	private static void dfs(int[] end, int d) {
		int x, y;
		x = end[0]; y = end[1];
		if (x == N - 1 && y == N - 1) {
			result++;
			return;
		}
		
		for (int i = 0; i < 3; i++) {
			if ((d == 0 && i == 1) || (d == 1 && i == 0)) continue;
			
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (!isIn(nx, ny)) continue;
			
			if (i == 0 || i == 1) {
				if (status[nx][ny] == 1 || status[nx][ny] == 2) continue;				
			}
			if (i == 2) {
				int cnt = 0;
				for (int j = 0; j < 3; j++) {
					int nnx = x + dx[j];
					int nny = y + dy[j];
					if (!isIn(nnx, nny)) continue;
					if (status[nnx][nny] == 1 || status[nnx][nny] == 2) continue;
					cnt++;
				}
				if (cnt != 3) continue;
			}
			
			status[nx][ny] = 2;
			dfs(new int[] {nx, ny}, i);
			status[nx][ny] = 0;
		}
	}
	
	private static boolean isIn(int x, int y) {
		if (x < 0 || x >= N || y < 0 || y >= N) return false;
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		
		status = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				status[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		if (status[N - 1][N - 1] == 1) {
			System.out.println(0);
			System.exit(0);
		}
		
		result = 0;
		dfs(new int[] {0, 1}, 0);
		System.out.println(result);
	}

}
