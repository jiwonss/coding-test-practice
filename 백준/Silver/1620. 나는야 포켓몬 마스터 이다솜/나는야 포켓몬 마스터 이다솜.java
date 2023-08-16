import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

	static int N, M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] temp = br.readLine().split(" ");
		N = Integer.parseInt(temp[0]);
		M = Integer.parseInt(temp[1]);
		
		Map<String, Integer> map = new HashMap<>();
		Map<Integer, String> map2 = new HashMap<>();
		for (int i = 0, idx = 1; i < N; i++, idx++) {
			String name = br.readLine();
			map.put(name, idx);
			map2.put(idx, name);
		}
		
		for (int i = 0; i < M; i++) {
			String str = br.readLine();
			if (Character.isDigit(str.charAt(0))) {
				sb.append(map2.get(Integer.parseInt(str))).append("\n");
			} else {
				sb.append(map.get(str)).append("\n");
			}
		}
		System.out.println(sb);
	}

}
