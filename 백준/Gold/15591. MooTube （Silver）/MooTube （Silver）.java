import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N, Q;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		
		List<int[]>[] graph = new ArrayList[N + 1];
		for (int i = 0; i < N + 1; i ++) {
			graph[i] = new ArrayList<>();
		}
		
		int p, q, r;
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			p = Integer.parseInt(st.nextToken());
			q = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			graph[p].add(new int[] {q, r});
			graph[q].add(new int[] {p, r});
		}
		
		int k, v;
		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			
			boolean[] visited = new boolean[N + 1];
			Queue<Integer> queue = new LinkedList<>();
			
			visited[v] = true;
			queue.add(v);
			
			int result = 0;
			while (!queue.isEmpty()) {
				int x = queue.poll();
				for (int[] g : graph[x]) {
					int a = g[0], b = g[1];
					if (!visited[a] && k <= b) {
						visited[a] = true;
						queue.add(a);
						result += 1;
					}
				}
			}
			System.out.println(result);
		}
	}

}
