import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());

		int result = 0;
		while (n != 0) {
			// n이 5로 나누어떨어지지 않는 경우 n - 3
			if (n % 5 != 0) {
				n -= 3;
				if (n < 0) {
					result = -1;
					break;
				}
				result++;
			} 
			// n이 5로 나누어떨어지는 경우 n - 5, result + 1
			else if (n % 5 == 0) {
				n -= 5;
				result++;
			} 
		}
		System.out.println(result);
	}

}
