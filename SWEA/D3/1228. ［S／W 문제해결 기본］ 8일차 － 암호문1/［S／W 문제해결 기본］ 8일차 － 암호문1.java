
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= 10; tc++) {
			sb.append("#").append(tc).append(" ");
			
			int n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			Deque<Integer> dq = new ArrayDeque<>();
			for (int i = 0; i < n; i++) {
				dq.offer(Integer.parseInt(st.nextToken()));
			}
			
			int k = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), "I ");
			while (st.hasMoreTokens()) {
				int x = Integer.parseInt(st.nextToken());
				for (int i = 0; i < x; i++) {
					dq.offerLast(dq.pollFirst());
				}
				int y = Integer.parseInt(st.nextToken());
				for (int i = 0; i < y; i++) {
					dq.offerLast(Integer.parseInt(st.nextToken()));
				}
				for (int i = 0; i < x + y; i++) {
					dq.offerFirst(dq.pollLast());
				}
			}
			
			for (int i = 0; i < 10; i++) {
				sb.append(dq.pollFirst()).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
		
	}

}