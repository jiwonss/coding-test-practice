import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
	int x;
	int y;
	int cost;
	
	public Node(int x, int y, int cost) {
		this.x = x;
		this.y = y;
		this.cost = cost;
	}
	
	@Override
	public int compareTo(Node o) {
		return Integer.compare(this.cost, o.cost);
	}
}

public class Main {
	
	static int N, result;
	static int[][] map, dist;
	static PriorityQueue<Node> pq;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int tc = 1;
		while (true) {
			N = Integer.parseInt(br.readLine());
			if (N == 0) break;
			
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			result = dijkstra();
			sb.append("Problem ").append(tc++).append(": ").append(result).append("\n");
		}
		System.out.println(sb);
	}
	
	public static int dijkstra() {
		dist = new int[N][N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		}
		
		dist[0][0] = map[0][0];
		
		pq = new PriorityQueue<>();
		pq.offer(new Node(0, 0, map[0][0]));
		
		while (!pq.isEmpty()) {
			Node node = pq.poll();
			int x = node.x, y = node.y;
			
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
				if (dist[nx][ny] > dist[x][y] + map[nx][ny]) {
					dist[nx][ny] = dist[x][y] + map[nx][ny];
					pq.offer(new Node(nx, ny, map[nx][ny]));
				}
			}
			
		}
		return dist[N - 1][N - 1];
	}

}
