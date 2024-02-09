import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class Point implements Comparable<Point>{
		int x;
		int y;
		int dist; 
		Point(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
		@Override
		public int compareTo(Point p) {
			if (this.dist != p.dist) {
				return Integer.compare(this.dist, p.dist);
			}
			if (this.x != p.x) {
				return Integer.compare(this.x, p.x);
			}
			return Integer.compare(this.y, p.y);				
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N, result;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	
	static Point shark;
	static int eatCnt = 0, sharkSize = 2;
	static PriorityQueue<Point> pq; 
	static Queue<Point> q;

	public static void main(String[] args) throws IOException {
		init();
		run();
		System.out.println(result);
	}
	
	public static void init() throws IOException {
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					shark = new Point(i, j, 0);
					map[i][j] = 0;
				}
			}
		}
	}
	
	public static void run() {
		result = 0;
		// 더 이상 먹을 수 있는 물고기가 없을 때 까지 이동
		while (true) {
			if (!bfs()) break;
		}
	}
	
	public static boolean bfs() {
		pq = new PriorityQueue<>();
		
		q = new ArrayDeque<>();
		visited = new boolean[N][N];
		
		visited[shark.x][shark.y] = true;
		q.offer(shark);
		
		while (!q.isEmpty()) {
			Point p = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				if (outOfBounds(nx, ny) || visited[nx][ny]) continue;
				if (map[nx][ny] > sharkSize) continue;
				visited[nx][ny] = true;
				q.offer(new Point(nx, ny, p.dist + 1));
				// 아기 상어 크기보다 작은 경우만 우선순위 큐에 추가
				if (map[nx][ny] != 0 && map[nx][ny] < sharkSize) {
					pq.offer(new Point(nx, ny, p.dist + 1));
				}
			}
		}
		
		// 몰고기가 없는 경우, 엄마 상어 호출
		if (pq.isEmpty()) return false;
		
		// 아기 상어가 먹을 수 있는 물고기 뽑기
		Point target = pq.poll();
		// 아기 상어 이동 및 물고기 먹기
		eatFish(target); 
		return true;
	}
	
	public static boolean outOfBounds(int x, int y) {
		if (x < 0 || x >= N || y < 0 || y >= N) return true;
		return false;
	}
	
	public static void eatFish(Point target) {
		// 아기 상어 이동 거리 추가
		result += target.dist;
		
		// 아기 상어 이동
		shark.x = target.x;
		shark.y = target.y;
		map[shark.x][shark.y] = 0;
		
		// 물고기 잡아먹기
		eatCnt++;
		if (eatCnt == sharkSize) {
			eatCnt = 0;
			sharkSize++;
		}
	}
	
}
