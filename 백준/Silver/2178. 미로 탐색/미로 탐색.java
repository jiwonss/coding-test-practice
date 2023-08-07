import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static class Point {
		private int x;
		private int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {

		int[] dx = {1, 0, -1, 0};
		int[] dy = {0, 1, 0, -1};
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N, M;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[N][M];
		for(int i = 0; i < N; i++) {
			char[] arr = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				map[i][j] = arr[j];
			}
		}
		
		Queue<Point> q = new LinkedList<Point>();
		int[][] visited = new int[N][M];
		
		q.add(new Point(0, 0));
		visited[0][0] = 1;
		
		while (!q.isEmpty()) {
			Point p = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
				if (visited[nx][ny] > 0 || map[nx][ny] == '0') continue;
				visited[nx][ny] = visited[p.x][p.y] + 1;
				q.add(new Point(nx, ny));
			}
		}
		System.out.println(visited[N - 1][M - 1]);
	}

}
