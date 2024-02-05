import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayDeque;
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
	
	static BufferedReader br;
	static StringTokenizer st;
	
	static int N, M;
	static int[][] map;
	static Queue<Point> q;
	static boolean[][] visited;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		init();
		bfs();
		System.out.println(check());
	}
	
	public static void init() throws IOException {
		br = new BufferedReader(new java.io.InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[M][N];
		for (int i = 0; i < M; i++) {
			String[] temp = br.readLine().split("");
			for (int j = 0; j < N; j++) {
				map[i][j] = temp[j].charAt(0) - '0';
			}
		}
		
		br.close();
	}
	
	public static void bfs() {
		q = new ArrayDeque<>();
		visited = new boolean[M][N];
		for (int i = 0; i < N; i++) {
			if (map[0][i] == 0) {
				q.offer(new Point(0, i));
				visited[0][i] = true;
			}
		}
		
		while (!q.isEmpty()) {
			Point p = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				if (outOfBounds(nx, ny) || visited[nx][ny]) continue;
				if (map[nx][ny] == 1) continue;
				visited[nx][ny] = true;
				q.offer(new Point(nx, ny));
			}
		}
	}
	
	public static boolean outOfBounds(int x, int y) {
		if (x < 0 || x >= M || y < 0 || y >= N) return true;
		return false;
	}
	
	public static String check() {
		for (int i = 0; i < N; i++) {
			if (visited[M - 1][i]) {
				return "YES";
			}
		}
		return "NO";
	}
	
}
