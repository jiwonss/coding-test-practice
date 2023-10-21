import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int k, n, cnt;
	static boolean[] visited;
	static char op;
	static PriorityQueue<int[]>  minPQ, maxPQ;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
			for (int t = 0; t < T; t++) {
				k = Integer.parseInt(br.readLine());
				
				visited = new boolean[k];
				minPQ = new PriorityQueue<>((o1, o2) -> {
					return Integer.compare(o1[0], o2[0]);
				});
				maxPQ = new PriorityQueue<>((o1, o2) -> {
					return Integer.compare(o2[0], o1[0]);
				});
				
				for (int i = 0; i < k; i++) {
					st = new StringTokenizer(br.readLine());
					op = st.nextToken().charAt(0);
					n = Integer.parseInt(st.nextToken());
					
					if (op == 'I') { // 삽입
						minPQ.offer(new int[] {n, i});
						maxPQ.offer(new int[] {n, i});
						visited[i] = true;
					} else { // 삭제
						if (n == 1) { // 최댓값
							if (!maxPQ.isEmpty()) {
								int[] v = maxPQ.poll();
								visited[v[1]] = false;
							}
						} else { // 최솟값
							if (!minPQ.isEmpty()) {
								int[] v = minPQ.poll();
								visited[v[1]] = false;
							}
						}
					}
					poll(minPQ.iterator(), minPQ);
					poll(maxPQ.iterator(), maxPQ);
				}
				
				if (minPQ.isEmpty() && maxPQ.isEmpty()) {
					sb.append("EMPTY").append("\n");
				} else {
					sb.append(maxPQ.poll()[0]).append(" ").append(minPQ.poll()[0]).append("\n");
				}
			}
			System.out.println(sb);
	}
	
	private static void poll(Iterator<int[]> iter, PriorityQueue<int[]> pq) {
		cnt = 0;
		while (iter.hasNext()) {
			int[] v = iter.next();
			if (!visited[v[1]]) {
				cnt++;	
			} else {
				break;
			}
		}
		for (int i = 0; i < cnt; i++) {
			pq.poll();
		}
	}

}
