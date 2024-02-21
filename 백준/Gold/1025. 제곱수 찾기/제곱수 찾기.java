import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N, M, result;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		init();
		solve();
		System.out.println(result);
	}
	
	public static void init() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = temp.charAt(j) - '0';
			}
		}
	}
	
	public static void solve() {
		result = -1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				for (int x = -N; x < N; x++) {
					for (int y = -M; y < M; y++) {
						if (x == 0 && y == 0) continue;
						int temp = 0;
						int nx = i, ny = j;
						while (isIn(nx, ny)) {
							temp = 10 * temp + map[nx][ny];
							if (isSquared(temp)) {
								result = Math.max(result, temp);
							}
							nx += x;
							ny += y;
						}
					}
				}
			}
		}
	}
	
	public static boolean isIn(int x, int y) {
		if (x < 0 || x >= N || y < 0 || y >= M) return false;
		return true;
	}
	
	public static boolean isSquared(int x) {
		return Math.sqrt(x) % 1 == 0;
	}

}
