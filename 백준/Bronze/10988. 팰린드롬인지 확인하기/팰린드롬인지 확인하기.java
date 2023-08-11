import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static char[] word;
	
	private static boolean palindrome() {
		int n = word.length;
		for (int i = 0; i < n / 2; i++) {
			if (word[i] != word[n - i - 1]) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		word = br.readLine().toCharArray();
		System.out.println(palindrome() ? 1 : 0);
	}

}
