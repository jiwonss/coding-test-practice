import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	
	static int T, N, M, C, profit;
	static int[] arr, selected;
	static int[][] map;
	static PriorityQueue<Integer> pq, temp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			pq = new PriorityQueue<>(Collections.reverseOrder());
			slidingWindow();
			
			profit = pq.poll() + pq.poll();
			sb.append(profit).append("\n");
		}
		System.out.println(sb);
	}
	
	private static void slidingWindow() {
		Deque<Integer> dq = null;
		for (int i = 0; i < N; i++) {
			dq = new ArrayDeque<>();
			temp = new PriorityQueue<>(Collections.reverseOrder());
			for (int j = 0; j < M; j++) {
				dq.offer(map[i][j]);				
			}
			arr = dequeToArray(dq);
			selected = new int[M];
			combination(0, 0);
			for (int j = M; j < N; j++) {
				dq.pollFirst();
				dq.offerLast(map[i][j]);
				arr = dequeToArray(dq);
				combination(0, 0);
			}
			pq.offer(temp.poll());
		}
	}
	
	private static int[] dequeToArray(Deque<Integer> dq) {
		int[] temp = new int[M];
		Iterator<Integer> it = dq.iterator();
		int idx = 0;
		while (it.hasNext()) {
			temp[idx++] = it.next();
		}
		return temp;
	}
	
	private static void combination(int k, int idx) {
		if (k == M) {
			int sum = 0;
			for (int i = 0; i < M; i++) {
				if (selected[i] == 1) {
					sum += arr[i];
				}
			}
			int result = 0;
			if (sum > 0 && sum <= C) {
				for (int i = 0; i < M; i++) {
					if (selected[i] == 1) {
						result += (arr[i] * arr[i]);
					}
				}
				if (!temp.contains(result)) {
					temp.offer(result);					
				}
			}	
			return;
		}
		selected[k] = 1;
		combination(k + 1, idx + 1);
		selected[k] = 0;
		combination(k + 1, idx);
	}

}
