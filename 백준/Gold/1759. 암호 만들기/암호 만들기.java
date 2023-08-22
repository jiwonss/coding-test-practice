import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int L, C;
	static char[] ch, password;
	static List<Character> vowel = Arrays.asList('a', 'e', 'i', 'o', 'u');
	static StringBuilder sb = new StringBuilder();
	
	private static void solve(int start, int k, int c, int v) {
		if (k == L) {
			if (c >= 2 && v >= 1) {
				sb.append(password).append("\n");
			}
			return;
		}
		for (int i = start; i < C; i++) {
			password[k] = ch[i];
			if (vowel.contains(ch[i])) {
				solve(i + 1, k + 1, c, v + 1);
			} else {
				solve(i + 1, k + 1, c + 1, v);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		ch = new char[C];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			ch[i] = st.nextToken().charAt(0);
		}
		
		Arrays.sort(ch);
		
		password = new char[L];
		solve(0, 0, 0, 0);
		System.out.println(sb);
	}

}
