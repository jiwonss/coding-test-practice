
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Island {
	int x, y;
	public Island(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class Vertex implements Comparable<Vertex>{
	int no;
	double weight;
	public Vertex(int no, double weight) {
		this.no = no;
		this.weight = weight;
	}
	@Override
	public int compareTo(Vertex o) {
		return Double.compare(this.weight, o.weight);
	}
	
}

public class Solution {
	
	static int N;
	static double result;
	static double[][] adjMatrix;
	static double E;
	static Island[] islandList;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			
			// 섬의 개수
			N = Integer.parseInt(br.readLine());

			// 각 섬들의 x좌표
			int[] x = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				x[i] = Integer.parseInt(st.nextToken());
			}
			
			// 각 섬들의 y좌표
			int[] y = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				y[i] = Integer.parseInt(st.nextToken());
			}
			
			// 섬 좌표 저장
			islandList = new Island[N];
			for (int i = 0; i < N; i++) {
				islandList[i] = new Island(x[i], y[i]);
			}
			
			// 해저터널 건설의 환경 부담 세율 실수
			E = Double.parseDouble(br.readLine());
			
			// 인접행렬
			adjMatrix = new double[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (i == j) continue;
					double distance = getDistance(islandList[i], islandList[j]);
					adjMatrix[i][j] = E * distance * distance;
				}
			}
			
			result = Long.MAX_VALUE;
			prim();
			sb.append(Math.round(result)).append("\n");
		}
		System.out.println(sb);
	}
	
	// 두 섬 사이의 거리 구하기
	private static double getDistance(Island a, Island b) {
		double aPow = Math.pow(a.x - b.x, 2);
		double bPow = Math.pow(a.y - b.y, 2);
		return Math.sqrt(aPow + bPow);
	}

	// 프림 알고리즘
	private static void prim() {
		double[] minEdge = new double[N];
		boolean[] visited = new boolean[N];
		PriorityQueue<Vertex> pq = new PriorityQueue<>();
		
		Arrays.fill(minEdge, Long.MAX_VALUE);
		minEdge[0] = 0;
		pq.offer(new Vertex(0, minEdge[0]));
		
		double cost = 0; 
		double min = 0.0;
		int minVertex = 0, cnt = 0;
		while (!pq.isEmpty()) {
			Vertex cur = pq.poll();
			minVertex = cur.no;
			min = cur.weight;
			if (visited[minVertex]) continue;
			
			visited[minVertex] = true;
			cost += min;
			if (++cnt == N) break;
			
			for (int i = 0; i < N; i++) {
				if (visited[i] || adjMatrix[minVertex][i] == 0) continue;
				if (minEdge[i] > adjMatrix[minVertex][i]) {
					minEdge[i] = adjMatrix[minVertex][i];
					pq.offer(new Vertex(i, minEdge[i]));
				}
			}
		}
		result = Math.min(result, cost);
	}

}
