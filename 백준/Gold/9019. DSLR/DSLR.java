import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int A, B;
    static boolean[] visited;
    static Queue<Calc> q;
    static char[] opName = {'D', 'S', 'L', 'R'};
    
    static class Calc {
    	int n;
    	String op;
    	public Calc(int n, String op) {
    		this.n = n;
    		this.op = op;
    	}
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            sb.append(bfs()).append("\n");
        } 
        System.out.println(sb);
    }
    
    private static String bfs() {
    	q = new ArrayDeque<>();
    	visited = new boolean[10000];
    	
    	visited[A] = true;
    	q.offer(new Calc(A, ""));
    	
    	while (!q.isEmpty()) {
    		Calc calc = q.poll();
    		int x = calc.n;
    		String op = calc.op;
    		for (int i = 0; i < 4; i++) {
    			int n = convert(i, x);
    			if (n == B) return op + opName[i];
    			if (!visited[n]) {
    				visited[n] = true;
    				q.offer(new Calc(n, op + opName[i]));
    			}
    		}
    	}
        return "";
    }
    
    private static int convert(int i, int n) {
        if (i == 0) return (2 * n) % 10000;
        if (i == 1) return (n != 0 ? n - 1 : 9999) % 10000;
        if (i == 2) return (n % 1000) * 10 + (n / 1000);
        return (n % 10) * 1000 + n / 10;
    }
    

}
