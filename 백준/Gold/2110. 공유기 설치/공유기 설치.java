import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N, C;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		init();
		solve();
	}
	
	public static void init() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
	}
	
	public static void solve() {
		Arrays.sort(arr);
		
		int start = 1, end = arr[N - 1] - arr[0] + 1;
		while (start < end) {
			int mid = (start + end) / 2;
			if (check(mid) < C) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		System.out.println(start - 1);
	}
	
	public static int check(int distance) {
		int cnt = 1, pre = arr[0];
		for (int i = 1; i < N; i++) {
			int cur = arr[i];
			if (cur - pre >= distance) {
				cnt++;
				pre = cur;
			}
		}
		return cnt;
	}

}
