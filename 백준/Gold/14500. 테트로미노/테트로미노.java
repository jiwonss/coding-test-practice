import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, M, max, result;
	static int[][] map, visited;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		max = 0;
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, map[i][j]);
			}
		}
		
		result = 0;
		visited = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visited[i][j] = 1;
				dfs(0, i, j, map[i][j]);				
				visited[i][j] = 0;
			}
		}
		System.out.println(result);
		
	}
	
	private static void dfs(int k, int x, int y, int sum) {
		if (result >= sum + max * (3 - k)) return;
		if (k == 3) {
			result = Math.max(result, sum);
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
			if (visited[nx][ny] == 1) continue;
			if (k == 1) {
				visited[nx][ny] = 1;
				dfs(k + 1, x, y, sum + map[nx][ny]);
				visited[nx][ny] = 0;
			}
			visited[nx][ny] = 1;
			dfs(k + 1, nx, ny, sum + map[nx][ny]);
			visited[nx][ny] = 0;
		}
	}

}
