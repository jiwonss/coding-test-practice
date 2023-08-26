import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N, d, k, c, result;
	static int[] sushi, visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		sushi = new int[N + k];
		for (int i = 0; i < N; i++) {
			sushi[i] = Integer.parseInt(br.readLine());
		}
		for (int i = 0; i < k; i++) {
			sushi[N + i] = sushi[i];
		}

		visited = new int[d + 1];
		System.out.println(slidingWindow());
	}
	
	// 슬라이딩 윈도우
	private static int slidingWindow() {
		// 손님이 먹을 수 있는 초밥 가짓수
		int cnt = 0;
		for (int i = 0; i < k; i++) {
			if (visited[sushi[i]] == 0) cnt++;
			visited[sushi[i]]++;
		}
			
		// 손님이 먹을 수 있는 초밥 가짓수의 최댓값
		int result = cnt;
		for (int i = 1; i <= N; i++) {
			if (result <= cnt) {
				result = cnt;
				if (visited[c] == 0) result++;
			}
			visited[sushi[i - 1]]--;
			if (visited[sushi[i - 1]] == 0) cnt--;
				
			if (visited[sushi[i + k - 1]] == 0) cnt++;
			visited[sushi[i + k - 1]]++;
		}
		return result;
	}
}