import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String s = br.readLine();
            if (s.equals(".")) {
                break;
            }
            Stack<Character> stack = new Stack<>();
            boolean check = false;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '(' || c == '[') {
                    stack.push(c);
                }
                if (c == ')') {
                    if (stack.isEmpty() || stack.peek() != '(') {
                        check = true;
                        break;
                    }
                    stack.pop();
                }
                if (c == ']') {
                    if (stack.isEmpty() || stack.peek() != '[') {
                        check = true;
                        break;
                    }
                    stack.pop();
                }
            }

            if (check || !stack.isEmpty()) {
                sb.append("no\n");
            } else {
                sb.append("yes\n");
            }
        }
        System.out.println(sb);
    }
}
