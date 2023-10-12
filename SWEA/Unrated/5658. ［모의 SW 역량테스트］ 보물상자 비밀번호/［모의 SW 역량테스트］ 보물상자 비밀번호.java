import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	static int N, K, result;
	static char[] lock;
	static List<String> list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			lock = br.readLine().toCharArray();
			
			list = new ArrayList<>();
			createPassword();
			
			Collections.sort(list, Collections.reverseOrder());
			result = Integer.parseInt(list.get(K - 1), 16);
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}
	
	private static void createPassword() {
		for (int k = 0; k < N / 3; k++) {
			for (int i = 0; i < N - 1; i += N / 4) {
				String password = new String(lock, i, N / 4);
				if (!list.contains(password)) {
					list.add(password);
				}
			}
			lock = rotate();	
		}
	}
	
	private static char[] rotate() {
		char[] temp = new char[N];
		for (int i = 0; i < N; i++) {
			temp[i] = lock[(i - 1 + N) % N];
		}
		return temp;
	}

}
