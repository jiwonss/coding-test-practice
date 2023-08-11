import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int N, result;
	static boolean[] select;
	static int[][] ingredient;
	
	// 두 음식의 맛 차이 구하기
	private static int getFlavorDiff() {
		// a : A음식의 맛, b : B음식의 맛
		int a = 0, b = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i == j) continue;
				// i, j 다 true인 경우, A음식 식재료 시너지
				if (select[i] && select[j]) {
					a += ingredient[i][j];
				}
				// i, j 다 false인 경우, B음식 식재료 시너지
				if (!select[i] && !select[j]) {
					b += ingredient[i][j];
				}
			}
		}
		return Math.abs(a - b);
	}
	
	// 재료 선택
	// select : true인 경우 A 음식의 식재료, false인 경우 B 음식의 식재료
	private static void selectIngredient(int start, int cnt) {
		if (cnt == N / 2) {
			result = Math.min(result, getFlavorDiff());
			return;
		}
		
		for (int i = start; i < N; i++) {
			select[i] = true;
			selectIngredient(i + 1, cnt + 1);
			select[i] = false;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			N = Integer.parseInt(br.readLine());
			
			ingredient = new int[N][N];
			select = new boolean[N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					ingredient[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			result = Integer.MAX_VALUE;
			selectIngredient(0, 0);
			sb.append(result).append("\n");
		}
		System.out.println(sb.toString());
	}

}
