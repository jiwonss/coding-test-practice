import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	
	static int N, L, result;
	static List<int[]> list;
	
	private static void combination(int idx, int score, int 
			calorie) {
		if (idx == N) {
			if (calorie > L) return;
			result = Math.max(result, score);
			return;
		}
		combination(idx + 1, score, calorie);
		combination(idx + 1, score + list.get(idx)[0], calorie + list.get(idx)[1]);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			list = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int t = Integer.parseInt(st.nextToken());
				int k = Integer.parseInt(st.nextToken());
				list.add(new int[] {t, k});
			}
		
			result = 0;
			combination(0, 0, 0);
			sb.append(result).append("\n");
		}
		System.out.println(sb.toString());
	}

}
