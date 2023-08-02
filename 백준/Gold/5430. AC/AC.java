import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] p = br.readLine().split("");
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), "[],");
            ArrayDeque<Integer> dq = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                dq.add(Integer.parseInt(st.nextToken()));
            }
            AC(p, dq);
        }
        System.out.println(sb);
    }
    
    public static void AC(String[] p, ArrayDeque<Integer> dq) {
        int reverse = -1;
        for (int i = 0; i < p.length; i++) {
            if (p[i].equals("R")) {
                reverse *= (-1);
            } else {
                if (dq.isEmpty()) {
                    sb.append("error\n");
                    return;
                }
                if (reverse == 1) {
                    dq.pollLast();
                } else {
                    dq.pollFirst();
                }
            }
        }
        print(reverse, dq);
    }

    public static void print(int reverse, ArrayDeque<Integer> dq) {
        sb.append("[");
        if (dq.size() > 0) {
            if (reverse == 1) {
                sb.append(dq.pollLast());
                while (!dq.isEmpty()) {
                    sb.append(",").append(dq.pollLast());
                }
            } else {
                sb.append(dq.pollFirst());
                while (!dq.isEmpty()) {
                    sb.append(",").append(dq.pollFirst());
                }
            }
        }
        sb.append("]").append("\n");
    }
}
