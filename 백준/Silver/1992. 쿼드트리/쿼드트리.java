import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int N;
	static int[][] video;
	static StringBuilder sb = new StringBuilder();
	
	private static boolean check(int n, int x, int y) {
		for (int i = x; i < x + n; i++) {
			for (int j = y; j < y + n; j++) {
				if (video[x][y] != video[i][j]) return false;
			}
		}
		return true;
	}
	
	private static void solve(int n, int x, int y) {
		if (check(n, x, y)) {
			sb.append(video[x][y]);
			return;
		}
		
		sb.append("(");
		int mid = n / 2;
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				solve(mid, x + i * mid, y + j * mid);
			}
		}
		sb.append(")");
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		video = new int[N][N];
		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			for (int j = 0; j < N; j++) {
				video[i][j] = temp.charAt(j) - '0';
			}
		}
		
		solve(N, 0, 0);
		System.out.println(sb);
	}

}
