import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		char[] str = br.readLine().toCharArray();
		for (int i = 0; i < str.length; i++) {
			if (str[i] >= 'a' && str[i] <= 'z') {
				if (str[i] < 'n') str[i] += 13;
				else str[i] -= 13;
			}
			if (str[i] >= 'A' && str[i] <= 'Z') {
				if (str[i] < 'N') str[i] += 13;
				else str[i] -= 13;
			}
		}

		for (char c : str) {
			sb.append(c);
		}
		System.out.println(sb);
	}

}
