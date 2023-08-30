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

	private static void dfs(int k, int cost, int last) {
		if (result <= cost) return; // 가지치기
		
		// 제일 최근에 방문한 도시
		if (k == N - 1) {
			int start = 0; // 처음 방문한 도시
			// 제일 마지막에 방문한 도시에서 처음 방문한 도시의 비용이 0이 아닌 경우, result 갱신
			if (W[last][start] != 0) {
				result = Math.min(result, cost + W[last][start]);
			}
			return;
		}
		
		for (int i = 1; i < N; i++) {
			if (visited[i] == 1 || W[last][i] == 0) continue;
			visited[i] = 1;
			dfs(k + 1, cost + W[last][i], i);
			visited[i] = 0;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		
		// 도시 i에서 도시 j로 가기 위한 비용 저장
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
		
		dfs(0, 0, 0);
		System.out.println(result);
	}

}
