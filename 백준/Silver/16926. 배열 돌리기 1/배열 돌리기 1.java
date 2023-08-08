import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n, m, r;
	static int[][] arr;
	
	private static void rotate() {
		int x, y, temp;
		int min = Math.min(n, m);
		for (int i = 0; i < min / 2; i++) {
			x = i; y = i;
			temp = arr[x][y];
			for (int j = i + 1; j < m - i; j++) {
				y = j;
				arr[x][y - 1] = arr[x][y];
			}
			
			for (int j = i + 1; j < n - i; j++) {
				x = j; y = m - i - 1;
				arr[x - 1][y] = arr[x][y];
			}

			for (int j = m - i - 2; j >= i; j--) {
				x = n - i - 1; y = j;
				arr[x][y + 1] = arr[x][y];
			}

			for (int j = n - i - 2; j >= i; j--) {
				x = j;
				arr[x + 1][y] = arr[x][y];
			}			
			arr[x + 1][y] = temp;
		}
	}
	
	private static void print() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		sb.append("\n");
		System.out.println(sb.toString());
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < r; i++) {
			rotate();
		}
		print();
	}

}