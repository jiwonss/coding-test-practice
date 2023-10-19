import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, result;
	static int[] board, visited;
	static Queue<Integer> q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		board = new int[101];

		int x, y;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			board[x] = y;
		}

		int u, v;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			board[u] = v;
		}

		result = bfs();
		System.out.println(result);
	}

	private static int bfs() {
		visited = new int[101];
		Arrays.fill(visited, -1);
		q = new ArrayDeque<>();

		visited[1] = 0;
		q.offer(1);

		while (!q.isEmpty()) {
			int x = q.poll();
			if (x == 100) return visited[100];
			for (int i = 1; i < 7; i++) {
				int nx = x + i;
				if (nx < 0 || nx > 100) continue;
				if (visited[nx] != -1) continue;
				visited[nx] = visited[x] + 1;
				if (board[nx] == 0) {
					q.offer(nx);
				} else {
					if (visited[board[nx]] != -1) continue;
					visited[board[nx]] = visited[x] + 1;
					q.offer(board[nx]);
				}
			}
		}
		return -1;
	}

}
