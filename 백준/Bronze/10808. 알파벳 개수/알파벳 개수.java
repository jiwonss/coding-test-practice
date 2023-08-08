import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] s = br.readLine().toCharArray();
		
		int[] freq = new int[26];
		for (char c : s) {
			freq[c - 'a']++;
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 26; i++) {
			sb.append(freq[i]).append(" ");
		}
		sb.append("\n");
		System.out.println(sb.toString());
	}

}