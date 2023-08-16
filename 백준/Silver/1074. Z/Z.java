import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, r, c;

	private static int z(int n, int r, int c) {
		if (n == 0) return 0;
		int half = 1 << (n - 1);
		if (r < half && c < half) {
			return z(n - 1, r, c);
		} else if (r < half && c >= half) {
			return half * half + z(n - 1, r, c - half);
		} else if (r >= half && c < half) {
			return 2 * half * half + z(n - 1, r - half, c);
		}
		return 3 * half * half + z(n - 1, r - half, c - half);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		System.out.println(z(N, r, c));
	}

}
