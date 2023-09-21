import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int T, n, result;
	static int[][] sticker, dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			n = Integer.parseInt(br.readLine());
			
			sticker = new int[2][n + 1];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i < n + 1; i++) {
				sticker[0][i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i < n + 1; i++) {
				sticker[1][i] = Integer.parseInt(st.nextToken());
			}
			
			dp = new int[2][n + 1];
			dp[0][1] = sticker[0][1]; dp[1][1] = sticker[1][1];
			
			for (int i = 2; i < n + 1; i++) {
				dp[0][i] += Math.max(dp[1][i - 1], dp[1][i - 2]) + sticker[0][i];
				dp[1][i] += Math.max(dp[0][i - 1], dp[0][i - 2]) + sticker[1][i];
			}
			result = Math.max(dp[0][n], dp[1][n]);
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}

}
