import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int newScore = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		
		if (n == 0) {
			System.out.println(1);
			return;
		}
		
		st = new StringTokenizer(br.readLine());
		List<Integer> score = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			score.add(Integer.parseInt(st.nextToken()));
		}
		
		if (n == p && newScore <= score.get(score.size() - 1)) {
			System.out.println(-1);
			return;
		}
		
		int rank = 1;
		for (int i = 0; i < score.size(); i++) {
			if (newScore < score.get(i)) {
				rank++;
			} else {
				break;
			}
		}
		System.out.println(rank);
	}

}
