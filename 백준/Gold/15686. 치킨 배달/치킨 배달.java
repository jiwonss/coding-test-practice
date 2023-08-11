import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, result;
	static int[] arr, visited;
	static List<int[]> home, chicken;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		home = new ArrayList<>();
		chicken = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int info = Integer.parseInt(st.nextToken());
				if (info == 1) {
					home.add(new int[] {i, j});
				}
				if (info == 2) {
					chicken.add(new int[] {i, j});
				}
			}
		}
		
		arr = new int[M];
		visited = new int[chicken.size()];
		result = Integer.MAX_VALUE;
		combination(0, 0);
		System.out.println(result);
		
	}
	
	// 조합
	private static void combination(int start, int k) {
		if (k == M) {
			result = Math.min(result, getDistance());
			return;
		}
		for (int i = start; i < chicken.size(); i++) {
			if (visited[i] == 1) continue;
			arr[k] = i;
			visited[i] = 1;
			combination(i + 1, k + 1);
			visited[i] = 0;
		}
	}

	// 치킨 거리 구하기
	private static int getDistance() {
		int cityDistance = 0;
		for (int i = 0; i < home.size(); i++) {
			int[] h = home.get(i);
			int homeDistance = Integer.MAX_VALUE;
			for (int j = 0; j < M; j++) {
				int idx = arr[j];
				int[] c = chicken.get(idx);
				int distance = Math.abs(c[0] - h[0]) + Math.abs(c[1] - h[1]);
				homeDistance = Math.min(homeDistance, distance);
			}
			cityDistance += homeDistance;
		}
		return cityDistance;
	}

}
