import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, result;
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		
		// 각각의 집을 빨강, 초록, 파랑으로 칠하는 비용 
		// dp[i][0] : i번째 집을 빨강으로 칠하는 비용
		// dp[i][1] : i번째 집을 초록으로 칠하는 비용
		// dp[i][2] : i번째 집을 파랑으로 칠하는 비용
		dp = new int[N][3];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				dp[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// i번째 집의 색은 i - 1번째 집의 색과 같지 않아야 한다.
		// 따라서 자신과 다른 색으로 칠하는 비용 중 작은 비용을 더해나간다.
		for (int i = 1; i < N; i++) {
			dp[i][0] += Math.min(dp[i - 1][1], dp[i - 1][2]);
			dp[i][1] += Math.min(dp[i - 1][0], dp[i - 1][2]);
			dp[i][2] += Math.min(dp[i - 1][0], dp[i - 1][1]);
		}
		
		// N개의 집을 칠하는 비용 중 최소 값 구하기
		result = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			if (result > dp[N - 1][i]) {
				result = dp[N - 1][i];
			}
		}
		System.out.println(result);
	}

}
