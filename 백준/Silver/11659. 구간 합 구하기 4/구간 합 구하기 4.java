import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		int n = Integer.parseInt(temp[0]);
		int m = Integer.parseInt(temp[1]);

		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		
		int[] num = new int[n];
		int idx = 0;
		while (st.hasMoreTokens()) {
			num[idx++] = Integer.parseInt(st.nextToken());
		}
		
		// 누적합
		int[] sum = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			sum[i] = sum[i - 1] + num[i - 1];
		}

		StringBuilder sb = new StringBuilder();
		for (int x = 0; x < m; x++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			int result = sum[j] - sum[i - 1];
			sb.append(result).append("\n");
		}
		System.out.println(sb.toString());
	}

}
