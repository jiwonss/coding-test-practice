import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N, result;
	static int[][] map;
	static int[][][] dir = { 
				{ { 0, 1, 0 }, { 1, 1, 2 } }, 
				{ { 1, 0, 1 }, { 1, 1, 2 } },
				{ { 0, 1, 0 }, { 1, 0, 1 }, { 1, 1, 2 } } 
			};

	public static void main(String[] args) throws IOException {
		init();
		result = 0;
		dfs(0, 1, 0);
		System.out.println(result);
	}

	public static void init() throws IOException {
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	public static void dfs(int x, int y, int d) {
		if (x == N - 1 && y == N - 1) {
			result++;
			return;
		}
		
		int nx, ny, nd;
		for (int i = 0; i < dir[d].length; i++) {
			nx = x + dir[d][i][0]; 
			ny = y + dir[d][i][1]; 
			nd = dir[d][i][2];
			if (!isIn(nx, ny) || map[nx][ny] == 1) continue;
			if (nd == 2 && (map[x + 1][y] == 1 || map[x][y + 1] == 1)) continue;
			dfs(nx, ny, nd);					
		}
		
	}
	
	public static boolean isIn(int x, int y) {
		if (x < 0 || x >= N || y < 0 || y >= N) return false;
		return true;
	}

}
