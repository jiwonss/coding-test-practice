import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();;
	
	static int N, M;
	static int[] arr, result;
	static boolean[] isSelected;
	

	public static void main(String[] args) throws IOException {
		init();
		solve(0);
		System.out.println(sb);
	}
	
	public static void init() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		result = new int[M];
		isSelected = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = i + 1;
		}
	}
	
	public static void solve(int k) {
		if (k == M) {
			for (int i = 0; i < M; i++) {
				sb.append(result[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (isSelected[i]) continue;
			isSelected[i] = true;
			result[k] = arr[i];
			solve(k + 1);
			isSelected[i] = false;
		}
	}
	
}
