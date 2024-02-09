import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static class Info {
		int x; 
		int y;
		int v;
		Info(int x, int y, int v) {
			this.x = x;
			this.y = y;
			this.v = v;
		}
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N, result;
	static int[] arr;
	static Info info = new Info(0, 0, Integer.MAX_VALUE);
	
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
		while (start < end) {
			sum = arr[start] + arr[end];
			if (Math.abs(sum) < info.v) {
				info = new Info(start, end, Math.abs(sum));
			}
			if (sum < 0) {
				start++;
			} else {
				end--;
			}
		}
		
		System.out.println(arr[info.x] + " " + arr[info.y]);
	}
	
}
