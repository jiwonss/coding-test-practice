import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, H, result;
	static int[][][] box;
	static Queue<int[]> q;
	static int[] dx = {0, 0, 1, 0, -1, 0}, dy = {0, 0, 0, 1, 0, -1}, dz = {1, -1, 0, 0, 0, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		q = new ArrayDeque<>();
		box = new int[H][N][M];
		for (int k = 0; k < H; k++) {
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					box[k][i][j] = Integer.parseInt(st.nextToken());
					if (box[k][i][j] == 1) {
						q.offer(new int[] {i, j, k});
					}
				}
			}
		}
		
		bfs();
		
		result = 0;
		for (int k = 0; k < H; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (box[k][i][j] == 0) {
						System.out.println(-1);
						return;
					}
					if (result < box[k][i][j]) result = box[k][i][j];
				}
			}
		}
		System.out.println(result - 1);
	}
	
	private static void bfs() {
		while (!q.isEmpty()) {
			int[] pos = q.poll();
			int x = pos[0], y = pos[1], z = pos[2];
			for (int i = 0; i < 6; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				int nz = z + dz[i];
				if (!isIn(nx, ny, nz)) continue;
				if (box[nz][nx][ny] != 0) continue;
				box[nz][nx][ny] = box[z][x][y] + 1;
				q.offer(new int[] {nx, ny, nz});
			}
		}
	}
	
	private static boolean isIn(int x, int y, int z) {
		return x >= 0 && x < N && y >= 0 && y < M && z >= 0 && z < H; 
	}
	
}
