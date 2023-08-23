import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	
	static int N, start, max, result;
	static int[] visited; // 연락 받은 순서 저장
	static List<List<Integer>> graph;
	static Queue<Integer> q;
	
	// bfs, 연락 돌리기
	private static void bfs() {
		visited[start] = 1;
		q.offer(start);
		while (!q.isEmpty()) {
			int x = q.poll();
			for (int v : graph.get(x)) {
				if (visited[v] != 0) continue;
				visited[v] = visited[x] + 1;
				max = Math.max(max, visited[v]);
				q.offer(v);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		for (int t = 1; t <= 10; t++) {
			sb.append("#").append(t).append(" ");
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			start =Integer.parseInt(st.nextToken());
			
			// graph 초기화
			graph = new ArrayList<>();
			for (int i = 0; i < 101; i++) {
				graph.add(new ArrayList<>());
			}
			
			// graph 입력, 단방향
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N / 2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				graph.get(from).add(to);
			}
			
			visited = new int[101];
			q = new ArrayDeque<>();
			max = 0; // 연락 순서 중 제일 마지막 순서 저장
			bfs();

			// 가장 나중에 연락을 받게 되는 사람 중 번호가 가장 큰 사람 찾기
			result = 0;
			for (int i = 0; i < 101; i++) {
				if (visited[i] == max) {
					result = Math.max(result, i);
				}
			}
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}

}
