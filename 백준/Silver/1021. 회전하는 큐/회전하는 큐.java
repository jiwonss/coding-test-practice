import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		Deque<Integer> dq = new LinkedList<>();
		for (int i = 1; i <= n; i++) {
			dq.offer(i);
		}
		
		int result = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			int k = Integer.parseInt(st.nextToken());
			int idx = ((LinkedList<Integer>) dq).indexOf(k);
			while (dq.peekFirst() != k) {
				if (idx < dq.size() - idx) {
					dq.offerLast(dq.pollFirst());
				} else {
					dq.offerFirst(dq.pollLast());
				}
				result++;
			}
			dq.pollFirst();
		}
		System.out.println(result);
	}

}
