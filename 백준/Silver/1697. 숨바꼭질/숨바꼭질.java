import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		int N = Integer.parseInt(temp[0]);
		int K = Integer.parseInt(temp[1]);
		
		Queue<Integer> q = new ArrayDeque<>();
		int[] visited = new int[100001];
		
		visited[N] = 1;
		q.offer(N);
		while (!q.isEmpty()) {
			int x = q.poll();
			if (x == K) {
				System.out.println(visited[x] - 1);
				return;
			}
			
			if (2 * x < 100001 && visited[2 * x] == 0) {
				visited[2 * x] = visited[x] + 1;
				q.offer(2 * x);
			}
			if (x - 1 >= 0 && visited[x - 1] == 0) {
				visited[x - 1] = visited[x] + 1;
				q.offer(x - 1);
			}
			if (x + 1 < 100001 && visited[x + 1] == 0) {
				visited[x + 1] = visited[x] + 1;
				q.offer(x + 1);
			}
		}
	}

}
