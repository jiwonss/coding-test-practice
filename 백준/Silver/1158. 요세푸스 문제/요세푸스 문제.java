import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		int n = Integer.parseInt(temp[0]);
		int k = Integer.parseInt(temp[1]);
		
		List<Integer> list = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			list.add(i);
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		int idx = k - 1;
		for (int i = 0; i < n; i++) {
			if (idx < list.size()) {
				sb.append(list.get(idx));
				list.remove(idx);
			} else {
				idx %= list.size();
				sb.append(list.get(idx));
				list.remove(idx);
			}
			idx += k - 1;
			if (i < n - 1) {
				sb.append(", ");
			}
		}
		sb.append(">");
		System.out.println(sb.toString());
		
	}

}
