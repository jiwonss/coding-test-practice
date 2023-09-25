import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, result;
	static int[][] board;
	static Queue<int[]> q;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		result = 0;
		dfs(0, copyBoard(board));
		System.out.println(result);
	}
	
	private static void dfs(int k, int[][] board) {
		if (k == 3) {
			q = new ArrayDeque<>();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (board[i][j] == 2) {
						q.offer(new int[] {i, j});
					}
				}
			}
			result = Math.max(result, bfs(board));
			return;
		}
		
		int[][] temp = copyBoard(board);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (temp[i][j] == 0) {
					temp[i][j] = 1;
					dfs(k + 1, copyBoard(temp));
					temp[i][j] = 0;
				}
			}
		}
	}
	
	private static int[][] copyBoard(int[][] board) {
		int[][] temp = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				temp[i][j] = board[i][j];
			}
		}
		return temp;
	}
	
	private static int bfs(int[][] board) {
		while (!q.isEmpty()) {
			int[] pos = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = pos[0] + dx[i];
				int ny = pos[1] + dy[i];
				if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
				if (board[nx][ny] != 0) continue;
				board[nx][ny] = 3;
				q.offer(new int[] {nx, ny});
			}
		}
		
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (board[i][j] == 0) cnt++;
			}
		}
		return cnt;
	}

}
