import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			
			Map<String, List<String>> map = new HashMap<>();
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				String name = st.nextToken();
				String type = st.nextToken();
				if (map.get(type) == null) {
					List<String> list = new ArrayList<>();
					list.add(name);
					map.put(type, list);
				} else {
					map.get(type).add(name);
				}
			}
			
			int result = 1;
			for (Entry<String, List<String>> entry : map.entrySet()) {
				result *= (entry.getValue().size() + 1);
			}
			System.out.println(result - 1);
		}
	}

}
