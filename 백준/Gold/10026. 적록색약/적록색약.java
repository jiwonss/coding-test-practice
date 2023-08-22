import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	
	static int N;
	static char[][] board;
	static Queue<int[]> q;
	static boolean[][] visited;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		board = new char[N][N];
		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			for (int j = 0; j < N; j++) {
				board[i][j] = temp.charAt(j);
			}
		}
		
		// 적록색약이 아닌 사람
		sb.append(getAreaCnt()).append(" ");
		
		// 적록색약인 사람
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j] == 'R') board[i][j] = 'G';
			}
		}
		sb.append(getAreaCnt()).append(" ");
		System.out.println(sb);
	}
	
	private static int getAreaCnt() {
		q = new ArrayDeque<>();
		visited = new boolean[N][N];
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					cnt++;
					bfs(i, j);
				}
			}
		}
		return cnt;
	}
	
	private static void bfs(int i, int j) {
		visited[i][j] = true;
		q.offer(new int[] {i, j});
		while (!q.isEmpty()) {
			int[] pos = q.poll();
			for (int d = 0; d < 4; d++) {
				int nx = pos[0] + dx[d];
				int ny = pos[1] + dy[d];
				if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
				if (visited[nx][ny] || board[pos[0]][pos[1]] != board[nx][ny]) continue;
				visited[nx][ny] = true;
				q.offer(new int[] {nx, ny});
			}
		}
	}

}
