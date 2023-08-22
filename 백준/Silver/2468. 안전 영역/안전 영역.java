import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, maxH, result;
	static Queue<int[]> q;
	static int[][] board, visited;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		
		board = new int[N][N];
		maxH = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				maxH = Math.max(maxH, board[i][j]);
			}
		}
		
		result = 0;
		for (int h = 0; h <= maxH; h++) {
			result = Math.max(result, safeArea(h));
		}
		System.out.println(result);
	}
	
	private static int safeArea(int h) {
		q = new ArrayDeque<>();
		visited = new int[N][N];
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visited[i][j] == 0 && board[i][j] > h) {
					visited[i][j] = 1;
					q.offer(new int[] {i, j});
					bfs(h);
					cnt++;
				}
			}
		}
		return cnt;
	}
	
	private static void bfs(int h) {
		while (!q.isEmpty()) {
			int[] pos = q.poll();
			for (int d = 0; d < 4; d++) {
				int nx = pos[0] + dx[d];
				int ny = pos[1] + dy[d];
				if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
				if (visited[nx][ny] == 1 || board[nx][ny] <= h) continue;
				visited[nx][ny] = 1;
				q.offer(new int[] {nx, ny});
			}
		}
	}

}
