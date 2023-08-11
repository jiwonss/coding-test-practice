import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			sb.append("#").append(tc).append(" ");
			int n = Integer.parseInt(br.readLine());
			int[][] board = new int[n][n];
			for (int i = 0; i < n; i++) {
				String[] temp = br.readLine().split("");
				for (int j = 0; j < n; j++) {
					board[i][j] = Integer.parseInt(temp[j]);
				}
			}

			int mid = n / 2;
			int start = mid, end = mid;
			int result = 0;
			for (int i = 0; i < n; i++) {
				for (int j = start; j < end + 1; j++) {
					result += board[i][j];
				}
				if (i < mid) {
					start = start - 1;
					end = end + 1;
				} else {
					start = start + 1;
					end = end - 1;
				}
			}
			sb.append(result).append("\n");
		}
		System.out.println(sb.toString());
	}

}
