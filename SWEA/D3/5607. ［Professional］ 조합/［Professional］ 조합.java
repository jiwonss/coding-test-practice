import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int N, R;
	static long result;
	static final int MOD = 1234567891;
	static long[] factorial = new long[1000001];
	
	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st = null;
		 StringBuilder sb = new StringBuilder();
		 
		 init();
		 
		 int T = Integer.parseInt(br.readLine());
		 for (int t = 1; t <= T; t++) {
			 sb.append("#").append(t).append(" ");
			 
			 st = new StringTokenizer(br.readLine());
			 N = Integer.parseInt(st.nextToken());
			 R = Integer.parseInt(st.nextToken());
			 
			 long a = factorial[N];
			 long b = (factorial[N - R] * factorial[R]) % MOD;
			 long c = pow(b, MOD - 2);
			 result = a * c % MOD;
			 
			 sb.append(result).append("\n");
		 }
		 System.out.println(sb);
	}
	
	private static void init() {
		factorial[0] = 1;
		for (int i = 1; i < 1000001; i++) {
			factorial[i] = factorial[i - 1] * i % MOD;
		}
	}
	
	private static long pow(long n, int r) {
		if (r == 1) return n;
		long x = pow(n, r / 2) % MOD;
		if (r % 2 == 0) {
			return x * x % MOD;
		}
		return ((x * x) % MOD * n) % MOD;
	}

}
