import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, result;
	static int[][] box;
	static Queue<int[]> q;
	static int[] dx = { 1, 0, -1, 0 }, dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		q = new ArrayDeque<>();
		box = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				if (box[i][j] == 1) {
					q.offer(new int[] { i, j });
				}
			}
		}

		bfs();

		result = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (box[i][j] == 0) {
					System.out.println(-1);
					return;
				}
				if (result < box[i][j]) result = box[i][j];
			}
		}
		System.out.println(result - 1);
	}

	private static void bfs() {
		while (!q.isEmpty()) {
			int[] pos = q.poll();
			int x = pos[0], y = pos[1];
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx < 0 || nx >= N || ny < 0 || ny >= M)
					continue;
				if (box[nx][ny] != 0)
					continue;
				box[nx][ny] = box[x][y] + 1;
				q.offer(new int[] { nx, ny });
			}
		}
	}

}
