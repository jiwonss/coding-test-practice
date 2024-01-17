import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class Point {
		int x;
		int y;
		
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static final int[] dx = {1, 0, -1, 0};
	static final int[] dy = {0, 1, 0, -1};
	
	static int M, N, result;
	static int[][] board, visited;
	static Deque<Point> q;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		board = new int[N][M];
		for (int i = 0; i < N; i++) {
			String[] temp = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(temp[j]);
			}
		}

		result = Integer.MAX_VALUE;
		bfs();
		System.out.println(result);
	}
	

	static void bfs() {
		q = new ArrayDeque<>();
		visited = new int[N][M];

		q.offer(new Point(0, 0));
		visited[0][0] = 1;
		
		while (!q.isEmpty()) {
			Point p = q.poll();
			if (p.x == N - 1 && p.y == M - 1) {
				result = Math.min(result, visited[p.x][p.y] - 1);
			}
			for (int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
				if (visited[nx][ny] != 0) continue;
				if (board[nx][ny] == 1) {
					visited[nx][ny] = visited[p.x][p.y] + 1;
					q.offer(new Point(nx, ny));
				} else {
					visited[nx][ny] = visited[p.x][p.y];
					q.offerFirst(new Point(nx, ny));
				}
			}
		}
	}

}
