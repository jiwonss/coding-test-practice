import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	
	static int n;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	
	private static int bfs(int i, int j) {
		Queue<int[]> q = new ArrayDeque<>();
		visited[i][j] = true;
		q.offer(new int[] {i, j});
		int cnt = 1;
		while (!q.isEmpty()) {
			int[] pos = q.poll();
			int x = pos[0], y = pos[1];
			for (int d = 0; d < 4; d++) {
				int nx = pos[0] + dx[d];
				int ny = pos[1] + dy[d];
				if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
				if (visited[nx][ny] || arr[nx][ny] - arr[x][y] != 1) continue;
				cnt++;
				visited[nx][ny] = true;
				q.offer(new int[] {nx, ny});
			}
		}		
		return cnt;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			sb.append("#").append(tc).append(" ");
			n = Integer.parseInt(br.readLine());
			
			arr = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			List<int[]> list = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					visited = new boolean[n][n];
					int cnt = bfs(i, j);
					list.add(new int[] {arr[i][j], cnt});
				}
			}

			Collections.sort(list, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					if (o1[1] == o2[1]) {
						return Integer.compare(o1[0], o2[0]);
					}
					return -Integer.compare(o1[1], o2[1]);
				}
				
			});
			
			int[] result = list.get(0);
			sb.append(result[0]).append(" ").append(result[1]).append("\n");
		}
		System.out.println(sb.toString());
	}

}
