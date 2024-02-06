import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class Point {
		int x;
		int y;
		int broken;
		Point(int x, int y, int broken) {
			this.x = x;
			this.y = y;
			this.broken = broken;
		}
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N, M;
	static int[][] map;
	static int[][][] visited;
	static Queue<Point> q;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		init();
		System.out.println(bfs());
	}
	
	public static void init() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = temp.charAt(j) - '0';
			}
		}
	}
	
	public static int bfs() {
		q = new ArrayDeque<>();
		visited = new int[N][M][2];
		
		visited[0][0][0] = 1;
		q.offer(new Point(0, 0, 0));
		
		while (!q.isEmpty()) {
			Point p = q.poll();
			if (p.x == N - 1 && p.y == M - 1) {
				return visited[p.x][p.y][p.broken];
			}
			for (int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				if (outOfBounds(nx, ny)) continue; 
				if (p.broken == 0 && map[nx][ny] == 1) {
					visited[nx][ny][1] = visited[p.x][p.y][0] + 1;
					q.offer(new Point(nx, ny, 1));
				}
				if (visited[nx][ny][p.broken] == 0 && map[nx][ny] == 0) {
					visited[nx][ny][p.broken] = visited[p.x][p.y][p.broken] + 1;
					q.offer(new Point(nx, ny, p.broken));										
				}
			}
		}
		return -1;
	}
	
	public static boolean outOfBounds(int x, int y) {
		if (x < 0 || x >= N || y < 0 || y >= M) return true;
		return false;
	}
	
}
