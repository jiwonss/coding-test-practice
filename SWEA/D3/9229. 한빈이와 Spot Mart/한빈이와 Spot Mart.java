import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int n, m, result;
	static int[] weight;
	
	private static void solve(int depth, int cnt, int sum) {
		if (cnt == 2 && sum <= m) {
			result = Math.max(result, sum);
			return;
		}
		if (depth == n || sum > m) return;
		solve(depth + 1, cnt, sum);
		solve(depth + 1, cnt + 1, sum + weight[depth]);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			sb.append("#").append(t).append(" ");
			
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			weight = new int[n];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				weight[i] = Integer.parseInt(st.nextToken());
			}

			result = -1;
			solve(0, 0, 0);
			sb.append(result).append("\n");
		}
		System.out.println(sb.toString());
	}

}
