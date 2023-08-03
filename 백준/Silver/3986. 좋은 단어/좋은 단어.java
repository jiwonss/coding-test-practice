import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        for (int i = 0; i < n; i++) {
            String[] word = br.readLine().split("");
            Stack<String> stack = new Stack<>();
            for (String w : word) {
                if (!stack.isEmpty() && w.equals(stack.peek())) {
                    stack.pop();
                } else {
                    stack.push(w);
                }
            }
            if (stack.isEmpty()) {
                answer += 1;
            }
        }
        System.out.println(answer);
    }
}
