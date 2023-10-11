import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int N, max, idx, result;
	static int[] distance;
	static long sum;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");

			N = Integer.parseInt(br.readLine());
			
			distance = new int[N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				distance[i] = Math.abs(x) + Math.abs(y);
			}
			
			max = distance[0];
			for (int i = 1; i < N; i++) {
				if (distance[i] % 2 != distance[i - 1] % 2) {
					max = -1;
					break;
				} 
				max = Math.max(max, distance[i]);
			}
			
			idx = 0;
			if (max != -1) {
				sum = 0;
				while (true) {
					sum += idx;
					if (sum >= max && (sum - max) % 2 == 0) {
						break;
					}
					idx++;
				}
			} else {
				idx = -1;
			}
			sb.append(idx).append("\n");
		}
		System.out.println(sb);
	}

}
