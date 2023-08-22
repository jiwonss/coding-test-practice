import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		String temp;
		while ((temp = br.readLine()) != null) {
			int n = Integer.parseInt(temp);
			int base = 1, cnt = 1;
			while ((base = base % n) != 0) {
				cnt++;
				base = base * 10 + 1;
			}
			System.out.println(cnt);
		}
	}

}
