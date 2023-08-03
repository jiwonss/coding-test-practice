import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < t; i++) {
			Stack<String> stack = new Stack<>();
			String[] str = br.readLine().split("");
			boolean check = false;
			for (String s : str) {
				if (s.equals("(")) {
					stack.push(s);
				} else {
					if (stack.isEmpty()) {
						check = true;
						break;
					}
					stack.pop();
				}
			}
			
			if (!stack.isEmpty() || check) {
				sb.append("NO").append("\n");
			} else {
				sb.append("YES").append("\n");
			}
		}
		System.out.println(sb.toString());
	}

}
