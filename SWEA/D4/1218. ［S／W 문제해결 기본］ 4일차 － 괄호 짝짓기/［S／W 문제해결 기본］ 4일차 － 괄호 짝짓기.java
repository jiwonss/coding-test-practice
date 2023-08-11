import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {
	
	static int n;
	static char[] str;
	
	private static boolean isValid() {
		Stack<Character> stack = new Stack<>();
		for (char c : str) {
			if (c == '(' || c == '[' || c =='{' || c == '<') { 
				stack.push(c);
			} else {
				if (stack.isEmpty()) {
					return false;
				}
				if (c == ')' && stack.peek() != '(') {
					return false;
				}
				if (c == ']' && stack.peek() != '[') {
					return false;
				}
				if (c == '}' && stack.peek() != '{') {
					return false;
				}
				if (c == '<' && stack.peek() != '<') {
					return false;
				}
				stack.pop();
			}
				
		}
		return stack.isEmpty() ? true : false;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= 10; tc++) {
			sb.append("#").append(tc).append(" ");
			n = Integer.parseInt(br.readLine());
			str = br.readLine().toCharArray();
			
			if (isValid()) {
				sb.append(1).append("\n");
			} else {
				sb.append(0).append("\n");
			}
		}
		System.out.println(sb.toString());
		
	}

}
