import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int win, lose;
	static int[] card, kCard, iCard, iSelect;
	static boolean[] select;
	
	// 카드 게임
	private static int game() {
		// kScore : 규영 점수, iScore : 인영 점수
		int kScore = 0, iScore = 0;
		for (int i = 0; i < 9; i++) {
			if (kCard[i] > iSelect[i]) {
				kScore += kCard[i] + iSelect[i];
			}
			if (kCard[i] < iSelect[i]) {
				iScore += kCard[i] + iSelect[i];
			}
		}
		// 무승부
		if (kScore == iScore) return 0;
		// 규영이가 이긴 경우
		if (kScore > iScore) return 1;
		// 규영이가 진 경우
		return -1;
	}
	
	// iCard : 인영이가 가지고 있는 카드
	// iSelect : 인영이가 게임에서 내는 카드를 순서대로 담은 배열
	private static void selectCard(int k) {
		if (k == 9) {
			// 카드 게임 진행
			int result = game();
			// 규영이가 이긴 경우 win++
			if (result == 1) win++;
			// 규영이가 진 경우 lose++
			if (result == -1) lose++;
			return;
		}
		
		for (int i = 0; i < 9; i++) {
			if (select[i]) continue;
			iSelect[k] = iCard[i];
			select[i] = true;
			selectCard(k + 1);
			select[i] = false;
		}
		
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			
			card = new int[19];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 9; i++) {
				card[Integer.parseInt(st.nextToken())] = 1;
			}
			
			// kCard : 규영 카드 및 순서, iCard : 인영 카드
			kCard = new int[9]; iCard = new int[9];
			int gIdx = 0, iIdx = 0;
			for (int i = 1; i < 19; i++) {
				if (card[i] == 1) {
					kCard[gIdx++] = i;
				} else {
					iCard[iIdx++] = i;
				}
			}
			
			select = new boolean[9];
			iSelect = new int[9];
			win = 0; lose = 0;
			selectCard(0);
		
			sb.append(win).append(" ").append(lose).append("\n");
		}
		System.out.println(sb.toString());
	}

}
