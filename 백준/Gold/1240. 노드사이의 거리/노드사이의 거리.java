import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static class Node {
		int v, d;
		Node(int v, int d) {
			this.v = v;
			this.d = d;
		}
		@Override
		public String toString() {
			return "Node [v=" + v + ", d=" + d + "]";
		}
		
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N, M, target;
	static List<List<Node>> graph;
	static boolean[] visited;
	
	
	public static void main(String[] args) throws IOException {
		init();
		solve();
	}

	
	public static void init() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList<>();
		for (int i = 0; i < N + 1; i++) {
			graph.add(new ArrayList<>());
		}
		
		int a, b, d;
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			graph.get(a).add(new Node(b, d));
			graph.get(b).add(new Node(a, d));
		}
	
	}
	
	public static void solve() throws IOException {
		int a, b;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			visited = new boolean[N + 1];
			target = b;
			dfs(a, 0);
		}
		
	}
	
	public static void dfs(int n, int distance) {
		if (n == target) {
			System.out.println(distance);
			return;
		}
		
		visited[n] = true;
		for (int i = 0; i < graph.get(n).size(); i++) {
			Node node = graph.get(n).get(i);
			int v = node.v, d = node.d;
			if (visited[v]) continue;
			dfs(v, distance + d);
		}
	}
	
}
