import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N, M, K, result;
	static int[] order, select;
	static int[][] arr, copyArr;
	static List<int[]> list;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		list = new ArrayList<>();
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			list.add(new int[] {r - 1, c - 1, s});
		}
		
		order = new int[K];
		select = new int[K];
		result = Integer.MAX_VALUE;
		permutation(0);
		System.out.println(result);
	}
	
	// 순열
	private static void permutation(int idx) {
		if (idx == K) {
			// 배열 복사
			copyArr();
			int r, c, s;
			int sx, ex, sy, ey;
			for (int i = 0; i < K; i++) {
				int[] info = list.get(order[i]);
				r = info[0]; c = info[1]; s = info[2]; 
				// 배열 회전
				sx = r - s; ex = r + s; sy = c - s; ey = c + s;
				while (sx < ex && sy < ey) {
					rotate(sx++, ex--, sy++, ey--);
				}
			}
			// 각 행의 합 중 최솟값 구하기
			getMinSum();
			return;
		}
		
		for (int i = 0; i < K; i++) {
			if (select[i] == 1) continue;
			order[idx] = i;
			select[i] = 1;
			permutation(idx + 1);
			select[i] = 0;
		}
	}
	
	// 배열 복사
	private static void copyArr() {
		copyArr = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				copyArr[i][j] = arr[i][j];
			}
		}
	}
	
	// 배열 회전하기
	private static void rotate(int sx, int ex, int sy, int ey) {
		int x, y, d, t;
		x = sx; y = sy; d = 0; t = copyArr[x][y];
		while (d < 4) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if (nx == sx && ny == sy) {
				copyArr[x][y] = t;
				return;
			}
			
			if (nx < sx || nx > ex || ny < sy || ny > ey) {
				d++;
				continue;
			}
			
			copyArr[x][y] = copyArr[nx][ny];
			x = nx; y = ny;
		}
	}
	
	// 각 행의 합 중 최솟값 구하기
	private static void getMinSum() {
		for (int i = 0; i < N; i++) {
			int sum = 0;
			for (int j = 0; j < M; j++) {
				sum += copyArr[i][j];
			}
			result = Math.min(result, sum);
		}
	}
}
