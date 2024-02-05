import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Point {
		int x; int y;
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N, M;
	static int[][] map;
	static Queue<Point> q;
	static boolean[][] visited;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		init();
		System.out.println(solve());
	}
	
	public static void init() throws IOException {
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[M][N];
		for (int i = 0; i < M; i++) {
			String temp = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = temp.charAt(j) - '0';
			}
		}
	}
	
	public static String solve() {
		visited = new boolean[M][N];
		for (int i = 0; i < N; i++) {
			if (map[0][i] == 1 || visited[0][i]) continue;
			if (bfs(0, i)) return "YES";
		}
		return "NO";
	}
	
	public static boolean bfs(int x, int y) {
		q = new ArrayDeque<>();
		q.offer(new Point(x, y));
		visited[x][y] = true;
		
		while (!q.isEmpty()) {
			Point p = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				if (outOfBounds(nx, ny)) continue;
				if (visited[nx][ny] || map[nx][ny] == 1) continue;
				if (nx == M - 1) return true;
				visited[nx][ny] = true;
				q.offer(new Point(nx, ny));
			}
		}
		return false;
	}
	
	public static boolean outOfBounds(int x, int y) {
		if (x < 0 || x >= M || y < 0 || y >= N) return true;
		return false;
	}
	
}
