import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N, M, result;
	static int[][] office;
	static List<int[]> cctv;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	
	static int[][][] mode = {
			{},
			{{0}, {1}, {2}, {3}},
			{{0, 2}, {1, 3}},
			{{0, 3}, {0, 1}, {1, 2}, {2, 3}},
			{{0, 2, 3}, {0, 1, 3}, {0, 1, 2}, {1, 2, 3}},
			{{0, 1, 2, 3}}
	};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		office = new int[N][M];
		cctv = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				office[i][j] = Integer.parseInt(st.nextToken());
				if (office[i][j] == 0 || office[i][j] == 6) continue;
				cctv.add(new int[] {office[i][j], i, j});
			}
		}
		
		result = N * M;
		dfs(0, copyOffice(office));
		System.out.println(result);
	}
	
	private static void dfs(int k, int[][] office) {
		if (k == cctv.size()) {
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (office[i][j] == 0) cnt++;					
				}
			}
			result = Math.min(result, cnt);
			return;
		}
		
		int[] info = cctv.get(k);
		int x = info[1], y = info[2];
		int[][] temp = copyOffice(office);
		for (int[] m : mode[info[0]]) {
			update(temp, m, x, y);
			dfs(k + 1, temp);
			temp = copyOffice(office);
		}
	}

	private static int[][] copyOffice(int[][] office) {
		int[][] copyOffice = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				copyOffice[i][j] = office[i][j];
			}
		}
		return copyOffice;
	}

	private static void update(int[][] temp, int[] direction, int x, int y) {
		for (int d : direction) {
			int nx = x, ny = y;
			while (true) {
				nx += dx[d];
				ny += dy[d];
				if (!isIn(nx, ny) || temp[nx][ny] == 6) break;
				if (temp[nx][ny] == 0) {
					temp[nx][ny] = 7;
				}
			}
		}
	}
	
	private static boolean isIn(int x, int y) {
		if (x < 0 || x >= N || y < 0 || y >= M) return false;
		return true;
	}
}
