import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	static int n, reverse;
	static boolean error;
	static String[] p;
	static Deque<String> dq;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			p = br.readLine().split("");
			n = Integer.parseInt(br.readLine());

			st = new StringTokenizer(br.readLine(), "[],");
			dq = new ArrayDeque<>();
			for (int i = 0; i < n; i++) {
				dq.offer(st.nextToken());
			}

			error = false;
			ac();
			print();
		}
		System.out.println(sb);
	}

	private static void ac() {
		reverse = 1;
		for (int i = 0; i < p.length; i++) {
			if (p[i].equals("R")) {
				reverse *= -1;
			} else {
				if (dq.isEmpty()) {
					error = true;
					return;
				}
				if (reverse == 1) {
					dq.pollFirst();
				} else {
					dq.pollLast();
				}
			}
		}
	}
	
	private static void print() {
		if (error) {
			sb.append("error").append("\n");
		} else {
			sb.append("[");
			if (dq.size() != 0) {
				if (reverse == 1) {
					sb.append(dq.pollFirst());
					while (!dq.isEmpty()) {
						sb.append(",").append(dq.pollFirst());
					}
				} else {
					sb.append(dq.pollLast());
					while (!dq.isEmpty()) {
						sb.append(",").append(dq.pollLast());
					}
				}				
			}
			sb.append("]").append("\n");
		}
	}

}
