import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static int V, E;
	static int[] parent;
	static Edge[] edgeList;
	
	static class Edge implements Comparable<Edge>{
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}

	private static void make() {
		parent = new int[V + 1];
		for (int i = 0; i < V + 1; i++) {
			parent[i] = i;
		}
	}
	
	private static int find(int x) {
		if (x == parent[x]) return x;
		return parent[x] = find(parent[x]);
	}
	
	private static boolean union(int a, int b) {
		int aParent = find(a);
		int bParent = find(b);
		if (aParent == bParent) return false;
		parent[bParent] = aParent;
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			edgeList = new Edge[E];
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				int C = Integer.parseInt(st.nextToken());
				edgeList[i] = new Edge(A, B, C);
			}
			
			Arrays.sort(edgeList);
			
			make();
			
			int cnt = 0;
			long result = 0;
			for (Edge edge : edgeList) {
				if (union(edge.from, edge.to)) {
					result += edge.weight;
					if (++cnt == V - 1) break;
				}
			}
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}

}
