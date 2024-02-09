import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N, x, y, result;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		init();
		solve();
	}

	public static void init() throws IOException {
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
	}
	
	public static void solve() {
		Arrays.sort(arr);
		
		int sum = 0;
		int start = 0, end = N - 1;
		x = 0; y = 0; result = Integer.MAX_VALUE;
		while (start < end) {
			sum = arr[start] + arr[end];
			if (Math.abs(sum) < result) {
				result = Math.abs(sum);
				x = start; y = end;
			}
			if (sum < 0) {
				start++;
			} else {
				end--;
			}
		}
		
		System.out.println(arr[x] + " " + arr[y]);
	}
	
}
