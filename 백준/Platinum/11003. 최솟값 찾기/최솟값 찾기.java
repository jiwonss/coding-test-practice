import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;


public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int N, L;
	static Deque<int[]> dq = new ArrayDeque<>();
	
	public static void main(String[] args) throws IOException {
		solve();
		System.out.println(sb);
	}
	
	public static void solve() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(st.nextToken());
			while (!dq.isEmpty() && dq.peekLast()[1] > n) {
				dq.pollLast();
			}
			while (!dq.isEmpty() && dq.peekFirst()[0] < i - L + 1) {
				dq.pollFirst();
			}
			dq.add(new int[] {i, n});
			sb.append(dq.peekFirst()[1]).append(" ");
		}
	}
	
}
