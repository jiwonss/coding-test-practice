import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N, M, result;
	static int[] startTeam, linkTeam;
	static int[][] map;
	static boolean[] isSelected;

	public static void main(String[] args) throws IOException {
		init();
		solve();
	}
	
	public static void init() throws IOException {
		N = Integer.parseInt(br.readLine());
		M = (int) N / 2;
		
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
	
	public static void solve() {
		isSelected = new boolean[N];
		result = Integer.MAX_VALUE;
		combination(0, 0);
		System.out.println(result);
	}
	
	public static void combination(int k, int start) {
		if (k == M) {
			startTeam = new int[M]; linkTeam = new int[M];
			int startIdx = 0, linkIdx = 0;
			for (int i = 0; i < N; i++) {
				if (isSelected[i]) {
					startTeam[startIdx++] = i;
				} else {
					linkTeam[linkIdx++] = i;
				}
			}
			result = Math.min(result, Math.abs(getAbility(startTeam) - getAbility(linkTeam)));
			return;
		}
		
		for (int i = start; i < N; i++) {
			if (isSelected[i]) continue;
			isSelected[i] = true;
			combination(k + 1, i + 1);
			isSelected[i] = false;
		}
	}

	public static int getAbility(int[] arr) {
		int sum = 0;
		for (int i = 0; i < M - 1; i++) {
			for (int j = i + 1; j < M; j++) {
				sum += (map[arr[i]][arr[j]] + map[arr[j]][arr[i]]);
			}
		}
		return sum;
	}
	
}
