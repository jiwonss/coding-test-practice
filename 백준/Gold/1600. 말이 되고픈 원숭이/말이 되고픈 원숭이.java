import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Pos {
	int x, y, k;
	public Pos(int x, int y, int k) {
		this.x = x;
		this.y = y;
		this.k = k;
	}
}

public class Main {

	static int K, W, H;
	static int[][] board;
	static int[][][] visited;
	static int[] hx = {2, 1, -1, -2, -2, -1, 1, 2};
	static int[] hy = {1, 2, 2, 1, -1, -2, -2, -1};
	static int[] mx = {1, 0, -1, 0}, my = {0, 1, 0, -1};
	static Queue<Pos> q = new ArrayDeque<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		K = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		board = new int[H][W];
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited = new int[H][W][K + 1];
		System.out.println(bfs());
	}
	
	private static int bfs() {
		q.offer(new Pos(0, 0, K));
		while (!q.isEmpty()) {
			Pos p = q.poll();
			if (p.x == H - 1 && p.y == W - 1) {
				return visited[H - 1][W - 1][p.k];
			}
			if (p.k > 0) {
				for (int d = 0; d < 8; d++) {
					int nx = p.x + hx[d];
					int ny = p.y + hy[d];
					if (!isIn(nx, ny)) continue;
					if (visited[nx][ny][p.k - 1] != 0 || board[nx][ny] == 1) continue;
					visited[nx][ny][p.k - 1] = visited[p.x][p.y][p.k] + 1;
					q.offer(new Pos(nx, ny, p.k - 1));
				}
			} 
			for (int d = 0; d < 4; d++) {
				int nx = p.x + mx[d];
				int ny = p.y + my[d];
				if (!isIn(nx, ny)) continue;
				if (visited[nx][ny][p.k] != 0 || board[nx][ny] == 1) continue;
				visited[nx][ny][p.k] = visited[p.x][p.y][p.k] + 1;
				q.offer(new Pos(nx, ny, p.k));
			}		
		}
		return -1;
	}
	
	private static boolean isIn(int x, int y) {
		if (x < 0 || x >= H || y < 0 || y >= W) return false;
		return true;
	}

}
