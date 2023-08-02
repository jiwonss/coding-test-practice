import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        Stack<Integer> stack = new Stack<>();
        int cnt = 1;
        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(br.readLine());
            while (cnt <= k) {
                stack.push(cnt);
                sb.append("+\n");
                cnt++;
            }
            if (stack.peek() != k) {
                System.out.println("NO");
                System.exit(0);
            }
            stack.pop();
            sb.append("-\n");
        }
        System.out.println(sb);
    }
}
