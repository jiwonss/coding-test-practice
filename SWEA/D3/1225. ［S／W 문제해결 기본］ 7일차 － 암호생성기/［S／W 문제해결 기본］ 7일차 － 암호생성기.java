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
			br.readLine();
			sb.append("#").append(tc).append(" ");
			
			st = new StringTokenizer(br.readLine());
			Deque<Integer> dq = new ArrayDeque<>();
			for (int i = 0; i < 8; i++) {
				dq.offer(Integer.parseInt(st.nextToken()));
			}
			
			int cnt = 1;
			while (dq.peekLast() > 0) {
				int x = dq.pollFirst() - cnt;
				dq.offerLast(x);
				cnt++;
				if (cnt > 5) {
					cnt = 1;
				}
			}
			
			dq.pollLast();
			dq.offer(0);
			
			for (int i = 0; i < 8; i++) {
				sb.append(dq.poll()).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

}
