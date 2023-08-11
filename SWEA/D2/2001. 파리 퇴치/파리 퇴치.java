import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[][] board = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			List<int[]> list = new ArrayList<>();
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < m; j++) {
					list.add(new int[] {i, j});
				}
			}
			
			int result = 0;
			for (int i = 0; i < n - m + 1; i++) {
				for (int j = 0; j < n - m + 1; j++) {
					int sum = 0;
					for (int k = 0; k < list.size(); k++) {
						int[] idx = list.get(k);
						sum += board[i + idx[0]][j + idx[1]];
					}
					result = Math.max(result, sum);
				}
			}
			sb.append(result).append("\n");
		}
		System.out.println(sb.toString());
		
	}

}
