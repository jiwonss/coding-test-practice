import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			String[] temp = br.readLine().split(" ");
			String op = temp[0];
			switch (op) {
				case "push":
					int x = Integer.parseInt(temp[1]);
					stack.push(x);
					break;
				case "pop":
					if (!stack.empty()) {
						sb.append(stack.pop()).append("\n");
					} else {
						sb.append(-1).append("\n");
					}
					break;
				case "size":
					sb.append(stack.size()).append("\n");
					break;
				case "empty":
					if (stack.empty()) {
						sb.append(1).append("\n");
					} else {
						sb.append(0).append("\n");
					}
					break;
				default:
					if (!stack.empty()) {
						sb.append(stack.peek()).append("\n");
					} else {
						sb.append(-1).append("\n");
					}
					break;
			}
		}
		System.out.println(sb.toString());
	}

}
