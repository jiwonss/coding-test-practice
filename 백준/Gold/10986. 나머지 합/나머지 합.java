import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static long N, M, result;
	static long[] A, cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		A = new long[(int) (N + 1)];
		cnt = new long[(int) M];
		
		result = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N + 1; i++) {
			A[i] = (A[i - 1] + Integer.parseInt(st.nextToken())) % M;
			if (A[i] == 0) result++;
			cnt[(int) A[i]]++;
		}
		
		for (int i = 0; i < M; i++) {
			if (cnt[i] > 1) {
				result += (cnt[i] * (cnt[i] - 1) / 2);
			}
		}
		System.out.println(result);
	}

}
