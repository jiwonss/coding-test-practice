import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static String pattern, front, back;
	
	private static boolean check(String name) {
		if (name.length() < pattern.length() - 1) return false;
		String a = name.substring(0, front.length());
		String b = name.substring(name.length() -  back.length(), name.length());
		if (a.equals(front) && b.equals(back)) return true;
		return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		pattern = br.readLine();
		st = new StringTokenizer(pattern, "*");
		front = st.nextToken(); back = st.nextToken();
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			sb.append(check(s) ? "DA" : "NE").append("\n");
		}
		System.out.println(sb);
	}

}
