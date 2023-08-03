import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int n;
	static StringBuilder sb = new StringBuilder();
	
	private static boolean isPrime(int k) {
		if (k < 2) {
			return false;
		}
		for (int i = 2; i * i <= k; i++) {
			if (k % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	private static void dfs(int k, int num) {
		if (k == n) {
			sb.append(num).append("\n");
			return;
		}
		
		for (int i = 1; i < 10; i++) {
			int temp = num * 10 + i;
			if (isPrime(temp)) {
				dfs(k + 1, temp);
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		for (int i : new int[] {2, 3, 5, 7}) {
			dfs(1, i);
		}
		System.out.println(sb.toString());
	}

}
