import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	static int N, result;
	static int[] visited;
	static int[][] W;

	private static void dfs(int k, int cost, Deque<Integer> dq) {
		if (result <= cost) return;
		
		int last = dq.peekLast();
		if (k == N - 1) {
			int start = dq.peekFirst();
			if (W[last][start] != 0) {
				result = Math.min(result, cost + W[last][start]);
			}
			return;
		}
		
		for (int i = 1; i < N; i++) {
			if (visited[i] == 1 || W[last][i] == 0) continue;
			visited[i] = 1;
			dq.offer(i);
			dfs(k + 1, cost + W[last][i], dq);
			visited[i] = 0;
			dq.pollLast();
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		
		W = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				W[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited = new int[N];
		result = Integer.MAX_VALUE;
		
		Deque<Integer> dq = new ArrayDeque<>();
		visited[0] = 1;
		dq.offer(0);
		
		dfs(0, 0, dq);
		System.out.println(result);
	}

}
