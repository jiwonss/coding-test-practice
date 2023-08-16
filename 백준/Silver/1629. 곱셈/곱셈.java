import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int A, B, C;
	
	private static long pow(int a, int b) {
		if (b == 1) {
			return a % C;
		}
		
		long v = pow(a, b / 2);
		v = v * v % C;
		if (b % 2 == 0) return v;
		return v * a % C;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		A = Integer.parseInt(temp[0]);
		B = Integer.parseInt(temp[1]);
		C = Integer.parseInt(temp[2]);
		
		System.out.println(pow(A, B));
	}

}