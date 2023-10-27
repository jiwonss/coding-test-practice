import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static String S;
	static char a;
	static int q, l, r;
	static int[][] map, sum;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		S = br.readLine();
		map = new int[26][S.length() + 1];
		for (int i = 1; i < S.length() + 1; i++) {
			int n = S.charAt(i - 1) - 'a';
			map[n][i]++;	
		}
		
		sum = new int[26][S.length() + 1];
		for (int i = 0; i < 26; i++) {
			for (int j = 1; j < S.length() + 1; j++) {
				sum[i][j] = sum[i][j - 1] + map[i][j];				
			}
		}
		
		q = Integer.parseInt(br.readLine());
		for (int i = 0; i < q; i++) {
			st = new StringTokenizer(br.readLine());
			a = st.nextToken().charAt(0);
			l = Integer.parseInt(st.nextToken()) + 1;
			r = Integer.parseInt(st.nextToken()) + 1;
			System.out.println(sum[a - 'a'][r] - sum[a - 'a'][l - 1]);
		}
	}

}
