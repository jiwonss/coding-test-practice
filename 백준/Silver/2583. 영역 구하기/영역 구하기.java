import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int M, N, K;
	static int[][] board, visited;
	static Queue<int[]> q = new ArrayDeque<>();
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		board = new int[N][M];
		int sx, sy, ex, ey;
		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			sx = Integer.parseInt(st.nextToken());
			sy = Integer.parseInt(st.nextToken());
			ex = Integer.parseInt(st.nextToken());
			ey = Integer.parseInt(st.nextToken());
			for (int i = sx; i < ex; i++) {
				for (int j = sy; j < ey; j++) {
					board[i][j] = 1;
				}
			}
		}
		
		int cnt = 0;
		List<Integer> area = new ArrayList<>();
		visited = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (visited[i][j] == 0 && board[i][j] == 0) {
					area.add(bfs(i, j));
					cnt++;
				}
			}
		}
		Collections.sort(area);
		
		StringBuilder sb = new StringBuilder();
		sb.append(cnt).append("\n");
		for (int i = 0; i < area.size(); i++) {
			sb.append(area.get(i)).append(" ");
		}
		System.out.println(sb);
	}

	private static int bfs(int i, int j) {
		int area = 1;
		visited[i][j] = 1;
		q.offer(new int[] {i, j});
		while (!q.isEmpty()) {
			int[] pos = q.poll();
			for (int d = 0; d < 4; d++) {
				int nx = pos[0] + dx[d];
				int ny = pos[1] + dy[d];
				if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
				if (visited[nx][ny] == 1 || board[nx][ny] == 1) continue;
				area++;
				visited[nx][ny] = 1;
				q.offer(new int[] {nx, ny});
			}
		}
		return area;
	}
}
