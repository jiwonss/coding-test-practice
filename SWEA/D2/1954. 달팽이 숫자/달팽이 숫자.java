import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0}; 

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append("\n");
			int n = Integer.parseInt(br.readLine());
			int[][] snail = new int[n][n];
			boolean[][] visited = new boolean[n][n];
			int x = 0, y = 0, d = 0;
			for (int i = 1; i <= n * n; i++) {
				snail[x][y] = i;
				visited[x][y] = true;
				int nx = x + dx[d];
				int ny = y + dy[d];
				if (nx < 0 || nx >= n || ny < 0 || ny >= n || visited[nx][ny]) {
					d = (d + 1) % 4;
				}
				x = x + dx[d];
				y = y + dy[d];				
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					sb.append(snail[i][j]).append(" ");
				}
				sb.append("\n");
			}
		}
		System.out.println(sb.toString());
	}

}
