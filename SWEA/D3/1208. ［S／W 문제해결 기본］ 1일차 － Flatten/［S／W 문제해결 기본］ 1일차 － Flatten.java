import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= 10; tc++) {
			sb.append("#" + tc + " ");
			int k = Integer.parseInt(br.readLine());
			List<Integer> h = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 100; i++) {
				h.add(Integer.parseInt(st.nextToken()));
			}
			for (int i = 0; i < k; i++) {
				int maxIdx = h.indexOf(Collections.max(h));
				int minIdx = h.indexOf(Collections.min(h));
				h.set(maxIdx, h.get(maxIdx) - 1);
				h.set(minIdx, h.get(minIdx) + 1);
			}
			int result = Collections.max(h) - Collections.min(h);
			sb.append(result + "\n");
		}
		System.out.println(sb.toString());
	}

}
