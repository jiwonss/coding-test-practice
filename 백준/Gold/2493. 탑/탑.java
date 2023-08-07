import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		Stack<int[]> stack = new Stack<>();
		stack.push(new int[] {100000001, 0});
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			int h = Integer.parseInt(st.nextToken());
			while (!stack.isEmpty() && stack.peek()[0] <= h) {
				stack.pop();
			}
			sb.append(stack.peek()[1]).append(" ");
			stack.push(new int[] {h, i + 1});
		}	
		sb.append("\n");
		System.out.println(sb.toString());
	}
}
