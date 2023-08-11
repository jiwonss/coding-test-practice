import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] bingo;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		// 빙고판
		bingo = new int[5][5];
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				bingo[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 사회자
		boolean check = false;
		int result = 0;
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++)	{
				int n = Integer.parseInt(st.nextToken());
				result++;
				remove(n);
				if (bingo()) {
					check = true;
					break;
				}
			}
			if (check) break;
		}
		System.out.println(result);
	}
	
	// 빙고판에서 사회자가 부르는 숫자 삭제
	private static void remove(int n) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (bingo[i][j] == n) {
					bingo[i][j] = 0;
					return;
				}
			}
		}
	}
	
	// 빙고 찾기
	private static boolean bingo() {
		int cnt;
		int bingoCnt = 0;
		
		// 찾는 방향 : \
		cnt = 0;
		for (int i = 0; i < 5; i++) {
			if (bingo[i][i] == 0) cnt++;
			else break;
		}
		if (cnt == 5) bingoCnt++;
		
		// 찾는 방향 : /
		cnt = 0;
		for (int i = 0; i < 5; i++) {
			if (bingo[i][5 - i - 1] == 0) cnt++;
			else break;
		}
		if (cnt == 5) bingoCnt++;
		
		// 찾는 방향 : ㅡ
		for (int i = 0; i < 5; i++) {
			cnt = 0;
			for (int j = 0; j < 5; j++) {
				if (bingo[i][j] == 0) cnt++;
				else break;
			}
			if (cnt == 5) bingoCnt++;
		}
		
		// 찾는 방향 : |
		for (int i = 0; i < 5; i++) {
			cnt = 0;
			for (int j = 0; j < 5; j++) {
				if (bingo[j][i] == 0) cnt++;
				else break;
			}
			if (cnt == 5) bingoCnt++;			
		}		
		if (bingoCnt >= 3) return true;
		return false;
	}

}