import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static int[] visited;
	static List<List<Integer>> graph;
	
	private static void dfs(int k, int x) {
		if (k == 4) {
			System.out.println(1);
			System.exit(0);
		}
		
		for (Integer v : graph.get(x)) {
			if (visited[v] == 1) continue;
			visited[v] = 1;
			dfs(k + 1, v);
			visited[v] = 0;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			graph.add(new ArrayList<>());
		}
		
		for (int i = 0 ; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		
		visited = new int[N];
		for (int i = 0; i < N; i++) {
			visited[i] = 1;
			dfs(0, i);
			visited[i] = 0;
		}
		System.out.println(0);
	}

}
