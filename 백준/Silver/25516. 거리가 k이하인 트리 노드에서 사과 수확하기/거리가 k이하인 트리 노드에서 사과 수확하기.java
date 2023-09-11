import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int n, k, result;
	static int[] appleInfo, visited;
	static List<List<Integer>> graph;
	
	private static void dfs(int n, int d) {
		if (d == k + 1) {
			return;
		}
		
		visited[n] = 1;
		result += appleInfo[n];
		for (int v : graph.get(n)) {
			if (visited[v] == 1) continue;
			dfs(v, d + 1);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<>());
		}
		
		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph.get(p).add(c);
		}
		
		appleInfo = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			appleInfo[i] = Integer.parseInt(st.nextToken());
		}
		
		visited = new int[n];
		dfs(0, 0);
		System.out.println(result);
	}

}

