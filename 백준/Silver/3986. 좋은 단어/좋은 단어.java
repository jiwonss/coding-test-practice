import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int result = 0;
		for (int t = 0; t < N; t++) {
			char[] word = br.readLine().toCharArray();
			Stack<Character> stack = new Stack<>();

			for (char w : word) {
				if (!stack.isEmpty() && w == stack.peek()) {
					stack.pop();
				} else {
					stack.push(w);
				}
			}
			
			if (stack.isEmpty()) {
				result++;
			}
		}
		System.out.println(result);
	}
}
