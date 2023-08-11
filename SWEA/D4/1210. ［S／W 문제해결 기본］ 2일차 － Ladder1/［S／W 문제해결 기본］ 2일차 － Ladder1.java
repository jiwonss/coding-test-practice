import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < 10; t++) {
			int tc = Integer.parseInt(br.readLine());
			sb.append("#" + tc + " ");
			int[][] board = new int[100][100];
			int x = 0, y = 0;
			for (int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
					if (board[i][j] == 2) {
						x = i;
						y = j;
					}
				}
			}
			
			boolean[][] visited = new boolean[100][100];
			while (x != 0) {
				visited[x][y] = true;
				if (y - 1 >= 0 && board[x][y - 1] == 1 && !visited[x][y - 1]) {
					y--;
				} else if (y + 1 < 100 && board[x][y + 1] == 1 && !visited[x][y + 1]) {
					y++;
				} else {
					x--;
				}
			}
			sb.append(y).append("\n");
		}
		System.out.println(sb.toString());
	}

}
