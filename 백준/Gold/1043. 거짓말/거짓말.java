import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N, M, knowCnt, comeCnt, result;
	static int[] parent;
	static boolean[] isTrue;
	static List<Integer>[] people;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		knowCnt = Integer.parseInt(st.nextToken());
		isTrue = new boolean[N + 1];
		for (int i = 0; i < knowCnt; i++) {
			int t = Integer.parseInt(st.nextToken());
			isTrue[t] = true;
		}
		
		
		people = new ArrayList[M];
		for (int i = 0; i < M; i++) {
			people[i] = new ArrayList<>();
		}
		
		init();
		
		int pre, nxt;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			comeCnt = Integer.parseInt(st.nextToken());
			pre = Integer.parseInt(st.nextToken());
			people[i].add(pre);
			for (int j = 0; j < comeCnt - 1; j++) {
				nxt = Integer.parseInt(st.nextToken());
				people[i].add(nxt);
				union(pre, nxt);
				pre = nxt;
			}
		}
		
		for (int i = 1; i < N + 1; i++) {
			if (isTrue[i]) {
				isTrue[find(i)] = true;
			}
		}
		
		int parent;
		result = 0;
		for (int i = 0; i < M; i++) {
			parent = find(people[i].get(0));
			if (!isTrue[parent]) result++;
		}
		System.out.println(result);
		
	}
	
	private static void init() {
		parent = new int[N + 1];
		for (int i = 1; i < N + 1; i++) {
			parent[i] = i;
		}
	}
	
	private static int find(int x) {
		if (x == parent[x]) return x;
		return parent[x] = find(parent[x]);
	}
	
	private static void union(int a, int b) {
		int aParent = find(a);
		int bParent = find(b);
		if (aParent == bParent) return;
		parent[aParent] = bParent;
	}
	
}
