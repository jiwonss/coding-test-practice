import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

	static int t, n;
	static int[] visited;
	static Point home, festival;
	static List<Point> store;
	
	static class Point {
		int x;
		int y;
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		t = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < t; tc++) {
			n = Integer.parseInt(br.readLine());
			
			int x, y;
			// 상근이네 집
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			home = new Point(x, y);
			// 편의점
			store = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				store.add(new Point(x, y));
			}
			// 락 페스티벌
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			festival = new Point(x, y);
			
			visited = new int[n + 1];
			sb.append(bfs()).append("\n");
		}
		System.out.println(sb);
	}

	private static String bfs() {
		Queue<Point> q = new ArrayDeque<>(); 
		q.offer(home);
		while (!q.isEmpty()) {
			Point cur = q.poll();
			if (getDistance(cur, festival) <= 1000) return "happy";
			for (int i = 0; i < n; i++) {
				Point nxt = new Point(store.get(i).x, store.get(i).y);
				if (getDistance(cur, nxt) > 1000) continue;
				if (visited[i] == 1) continue;
				visited[i] = 1;
				q.offer(nxt);
			}
		}
		return "sad";
	}
	
	private static int getDistance(Point p1, Point p2) {
		return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
	}

}
