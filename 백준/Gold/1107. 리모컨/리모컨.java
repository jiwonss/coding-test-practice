import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N, M, result;
	static List<Integer> broken;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		broken = new ArrayList<>();
		if (M != 0) {
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				broken.add(Integer.parseInt(st.nextToken()));
			}
		} 
		
		result = Math.abs(100 - N);
		for (int i = 0; i < 1000001; i++) {
			String num = String.valueOf(i);
			boolean flag = true;
			for (int j = 0; j < num.length(); j++) {
				if (broken.contains(num.charAt(j) - '0')) {
					flag = false;
					break;
				}
			}
			if (flag) {
				result = Math.min(result, num.length() + Math.abs(i - N));				
			}
		}
		System.out.println(result);
	}

}
