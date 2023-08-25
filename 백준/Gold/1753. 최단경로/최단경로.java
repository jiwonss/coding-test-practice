import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
	int v, w;
	public Node(int v, int w) {
		this.v = v;
		this.w = w;
	}
	@Override
	public int compareTo(Node o) {
		return Integer.compare(this.w, o.w);
	}
}

public class Main {

	static int V, E, K, INF = Integer.MAX_VALUE;
	static int[] distance;
	static List<List<Node>> graph;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		K = Integer.parseInt(br.readLine());
		
		graph = new ArrayList<>();
		for (int i = 0; i < V + 1; i++) {
			graph.add(new ArrayList<>());
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph.get(u).add(new Node(v, w));
		}
		
		distance = new int[V + 1];
		Arrays.fill(distance, INF);
		
		dijkstra(K);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < V + 1; i++) {
			sb.append(distance[i] != INF ? distance[i] : "INF").append("\n");
		}
		System.out.println(sb);
	}

	private static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		distance[start] = 0;
		while (!pq.isEmpty()) {
			Node node = pq.poll();
			int d = node.w, now = node.v;
			if (distance[now] < d) continue;
			for (Node n : graph.get(now)) {
				int cost = d + n.w;
				if (cost < distance[n.v]) {
					distance[n.v] = cost;
					pq.offer(new Node(n.v, cost));
				}
			}
		}
	}
	
}
