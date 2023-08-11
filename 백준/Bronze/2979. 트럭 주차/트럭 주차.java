import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int[] check = new int[101];
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			for (int k = n; k < m; k++) {
				check[k]++;
			}
		}
		
		int result = 0;
		for (int i = 1; i <= 100; i++) {
			switch (check[i]) {
				case 1:
					result += a;
					break;
				case 2:
					result += 2 * b;
					break;
				case 3:
					result += 3 * c;
					break;
			}
		}
		System.out.println(result);
	}

}

