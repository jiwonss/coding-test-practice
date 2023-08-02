import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Queue<Integer> q = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		int x = 0;
		for (int i = 0; i < n; i++) {
			String[] temp = br.readLine().split(" ");
			String op = temp[0];
			switch (op) {
				case "push":
					x = Integer.parseInt(temp[1]);
					q.offer(x);
					break;
				case "pop":
					if (!q.isEmpty()) {
						sb.append(q.poll()).append("\n");
					} else {
						sb.append(-1).append("\n");
					}
					break;
				case "size":
					sb.append(q.size()).append("\n");
					break;
				case "empty":
					if (q.isEmpty()) {
						sb.append(1).append("\n");
					} else {
						sb.append(0).append("\n");
					}
					break;
				case "front":
					if (!q.isEmpty()) {
						sb.append(q.peek()).append("\n");
					} else {
						sb.append(-1).append("\n");
					}
					break;
				default:
					if (!q.isEmpty()) {
						sb.append(x).append("\n");
					} else {
						sb.append(-1).append("\n");
					}
					break;
			}
		}
		System.out.println(sb.toString());
	}

}
