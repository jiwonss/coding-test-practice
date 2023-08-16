import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] score;
	static int[] home;
	static int[] away;
	
	private static boolean game(int k) {
		if (k == 15) return true;
		
		// 숭리
		if (score[home[k]][0] > 0 && score[away[k]][2] > 0) {
			score[home[k]][0]--;
			score[away[k]][2]--;
			if (game(k + 1)) return true;
			score[home[k]][0]++;
			score[away[k]][2]++;
		}
		
		// 무승부
		if (score[home[k]][1] > 0 && score[away[k]][1] > 0) {
			score[home[k]][1]--;
			score[away[k]][1]--;
			if (game(k + 1)) return true;
			score[home[k]][1]++;
			score[away[k]][1]++;
		}
		
		// 패배
		if (score[home[k]][2] > 0 && score[away[k]][0] > 0) {
			score[home[k]][2]--;
			score[away[k]][0]--;
			if (game(k + 1)) return true;
			score[home[k]][2]++;
			score[away[k]][0]++;
		}
		return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		home = new int[15];
		away = new int[15];
		int idx = 0;
		for (int i = 0; i < 6; i++) {
			for (int j = i + 1; j < 6; j++) {
				home[idx] = i;
				away[idx] = j;
				idx++;
			}
		}
		
		// 네 가지 결과
		for (int t = 0; t < 4; t++) {
			// 6개국 결과 score에 저장
			score = new int[6][3];
			st = new StringTokenizer(br.readLine());
			int sum = 0;
			for (int i = 0; i < 18; i++) {
				int temp = Integer.parseInt(st.nextToken());
				score[i / 3][i % 3] = temp;
				sum += temp;
			}
			if (sum > 30) sb.append(0).append(" ");
			else sb.append(game(0) ? 1 : 0).append(" ");
		}
		System.out.println(sb);
	}

}
