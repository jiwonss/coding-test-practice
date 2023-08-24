import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N, result;
	static int[] population, selected, visited;
	static List<Integer> A, B;
	static List<List<Integer>> graph;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		// 구역 개수
		N = Integer.parseInt(br.readLine());

		// 구역 인구
		population = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N + 1; i++) {
			population[i] = Integer.parseInt(st.nextToken());
		}
		
		// 각 구역과 인접한 구역 정보
		graph = new ArrayList<>();
		for (int i = 0; i < N + 1; i++) {
			graph.add(new ArrayList<>());
		}
	
		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			for (int j = 0; j < n; j++) {
				int v = Integer.parseInt(st.nextToken());
				graph.get(i).add(v);
			}
		}

		// 2개의 선거구를 구하기 위한 조합
		result = Integer.MAX_VALUE;
		for (int i = 1; i < N / 2 + 1; i++) {
			selected = new int[N + 1];
			combination(1, 0, i);
		}
		System.out.println(result != Integer.MAX_VALUE ? result : -1);
	}
	
	// 2개의 선거구를 구하기 위한 조합
	private static void combination(int start, int k, int cnt) {
		if (k == cnt) {
			// A선거구 : selected = 1, B선거구 : selected = 0
			A = new ArrayList<>();
			B = new ArrayList<>();
			for (int i = 1; i < N + 1; i++) {
				if (selected[i] == 1) A.add(i);
				else B.add(i);
			}
			// 각 선거구 연결 확인
			// 연결되어 있으면 성공적으로 두 선거구를 나눈 것이다.
			if (check(A) && check(B)) {
				result = Math.min(result, getPopulationDiff());
			}
			return;
		}
		
		for (int i = start;  i < N + 1; i++) {
			selected[i] = 1;
			combination(i + 1, k + 1, cnt);
			selected[i] = 0;
		}
	}
	
	// 선거구 연결 확인
	private static boolean check(List<Integer> district) {
		visited = new int[N + 1];
		dfs(district.get(0), district);
		
		// dfs 결과와 선거구의 구역 개수가 같으면 true, 다르면 false
		int cnt = 0;
		for (int i = 0; i < N + 1; i++) {
			cnt += visited[i];
		}
		if (cnt == district.size()) return true;
		return false;
	}
	
	// dfs, 선거구 구역에 포함되는 경우만 진행
	private static void dfs(int x, List<Integer> district) {
		visited[x] = 1;
		for (int v : graph.get(x)) {
			if (visited[v] == 1 || !district.contains(v)) continue;
			dfs(v, district);
		}
	}
	
	// 두 선거구의 인구 차이 구하기
	private static int getPopulationDiff() {
		int aSum = 0;
		for (int a : A) {
			aSum += population[a];
		}
		int bSum = 0;
		for (int b : B) {
			bSum += population[b];
		}
		return Math.abs(aSum - bSum);
	}
	
}

