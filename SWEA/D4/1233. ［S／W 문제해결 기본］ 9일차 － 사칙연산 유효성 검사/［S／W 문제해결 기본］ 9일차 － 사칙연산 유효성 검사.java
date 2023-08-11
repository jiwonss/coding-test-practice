import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		for(int tc = 1; tc <= 10; tc++) {
			sb.append("#").append(tc).append(" ");
			int n = Integer.parseInt(br.readLine());
			
			int result = 1;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				st.nextToken();
				char op = st.nextToken().charAt(0);
				if (st.hasMoreTokens() && Character.isDigit(op)) {
					result = 0;
				} 
				if (!st.hasMoreTokens() && !Character.isDigit(op)) {
					result = 0;
				}
			}
			sb.append(result).append("\n");
		}
		System.out.println(sb.toString());
	}

}
