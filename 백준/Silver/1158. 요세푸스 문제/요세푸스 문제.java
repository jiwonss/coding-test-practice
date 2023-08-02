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
		
		List<Integer> people = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			people.add(i + 1);
		}

		StringBuilder sb = new StringBuilder();
		int idx = k - 1;
		sb.append("<");
		for (int i = 0; i < n; i++) {
			if (idx < people.size()) {
				sb.append(people.get(idx));
				people.remove(idx);
			} else {
				idx = idx % people.size();
				sb.append(people.get(idx));
				people.remove(idx);
			}
			idx += k - 1;
			if (!people.isEmpty()) {
				sb.append(", ");
			}
		}
		sb.append(">");
		System.out.println(sb.toString());
		
	}

}
