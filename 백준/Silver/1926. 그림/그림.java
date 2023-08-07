import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {

	static int n, m;
	static int[][] board;
	static boolean[][] visited;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	
	private static int[] bfs() {
		int[] result = new int[2];
		Queue<int[]> q = new ArrayDeque<>();
		visited = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!visited[i][j] && board[i][j] == 1) {
					result[0]++;
					visited[i][j] = true;
					q.offer(new int[] {i, j});
					int width = 1;
					while (!q.isEmpty()) {
						int[] pos = q.poll();
						for (int d = 0; d < 4; d++) {
							int nx = pos[0] + dx[d];
							int ny = pos[1] + dy[d];
							if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
							if (visited[nx][ny] || board[nx][ny] == 0) continue;
							width++;
							visited[nx][ny] = true;
							q.offer(new int[] {nx, ny});
						}
					}
					result[1] = Math.max(result[1], width);
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		String[] temp = br.readLine().split(" ");
		n = Integer.parseInt(temp[0]);
		m = Integer.parseInt(temp[1]);
		board = new int[n][m];
		visited = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] result = bfs();
		System.out.println(result[0]);
		System.out.println(result[1]);
	}

}
