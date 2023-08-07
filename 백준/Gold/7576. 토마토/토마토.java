import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int n, m;
	static int[][] box;
	static Queue<Point> q = new ArrayDeque<>();
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	
	static class Point {
		private int x;
		private int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	private static void bfs() {
		while (!q.isEmpty()) {
			Point p = q.poll();
			for (int d = 0; d < 4; d++) {
				int nx = p.x + dx[d];
				int ny = p.y + dy[d];
				if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
				if (box[nx][ny] != 0) continue;
				box[nx][ny] = box[p.x][p.y] + 1;
				q.offer(new Point(nx, ny));
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st = null;
		 String[] temp = br.readLine().split(" ");
		 m = Integer.parseInt(temp[0]);
		 n = Integer.parseInt(temp[1]);
		 box = new int[n][m];
		 for (int i = 0; i < n; i++) {
			 st = new StringTokenizer(br.readLine());
			 for (int j = 0; j < m; j++) {
				 box[i][j] = Integer.parseInt(st.nextToken());
				 if (box[i][j] == 1) {
					 q.offer(new Point(i, j));
				 }
			 }
		 }
		 
		 bfs();
		 
		 int result = 0;
		 for (int i = 0; i < n; i++) {
			 for (int j = 0; j < m; j++) {
				 if (box[i][j] == 0) {
					 System.out.println(-1);
					 return;
				 }
				 if (result < box[i][j]) {
					 result = box[i][j];
				 }
			 }
		 }
		 System.out.println(result - 1);
	}

}
