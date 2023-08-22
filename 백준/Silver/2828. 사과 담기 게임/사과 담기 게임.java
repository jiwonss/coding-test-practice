import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M, J;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		J = Integer.parseInt(br.readLine());
		int start = 1, end = M, result = 0;
		for (int i = 0; i < J; i++) {
			int k = Integer.parseInt(br.readLine());
			if (k >= start && k <= end) continue;
			while (k < start && end <= N) {
				start--; end--;
				result++;
			}
			while (k > end && start > 0) {
				start++; end++;
				result++;
			}
		}
		System.out.println(result);
	}

}
