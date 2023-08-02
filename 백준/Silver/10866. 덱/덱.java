import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> dq = new LinkedList<>();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            String[] op = br.readLine().split(" ");
            switch (op[0]) {
                case "push_front":
                    int x1 = Integer.parseInt(op[1]);
                    dq.addFirst(x1);
                    break;
                case "push_back":
                    int x2 = Integer.parseInt(op[1]);
                    dq.addLast(x2);
                    break;
                case "pop_front":
                    if (dq.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(dq.pollFirst()).append("\n");
                    }
                    break;
                case "pop_back":
                    if (dq.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(dq.pollLast()).append("\n");
                    }
                    break;
                case "size":
                    sb.append(dq.size()).append("\n");
                    break;
                case "empty":
                    if (dq.isEmpty()) {
                        sb.append(1).append("\n");
                    } else {
                        sb.append(0).append("\n");
                    }
                    break;
                case "front":
                    if (dq.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(dq.getFirst()).append("\n");
                    }
                    break;
                case "back":
                    if (dq.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(dq.getLast()).append("\n");
                    }
                    break;
            }
        }
        System.out.println(sb);
    }
}
