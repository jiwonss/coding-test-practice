import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int N;
	static int[][] video;
	static StringBuilder sb = new StringBuilder();
	
	// 주어진 범위 영상이 모두 같은 값으로 이루어져 있는지 확인하는 메서드
	private static boolean check(int x, int y, int n) {
		for (int i = x; i < x + n; i++) {
			for (int j = y; j < y + n; j++) {
				if (video[x][y] != video[i][j]) return false;
			}
		}
		return true;
	}
	
	// 영상 압축
	private static void solve(int x, int y, int n) {
		// 주어진 범위 영상이 모두 같은 값으로 이루어져 있으면 압축
		if (check(x, y, n)) {
			sb.append(video[x][y]);
			return;
		}
		
		// 4개의 영역으로 나누어서 진행
		sb.append("(");
		int mid = n / 2;
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				solve(x + i * mid, y + j * mid, mid);
			}
		}
		sb.append(")");
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력
		N = Integer.parseInt(br.readLine());
		video = new int[N][N];
		for (int i = 0; i < N; i++) {
			String[] temp = br.readLine().split("");
			for (int j = 0; j < N; j++) {
				video[i][j] = Integer.parseInt(temp[j]);
			}
		}
		
		// 압축
		solve(0, 0, N);
		
		// 압축 결과
		System.out.println(sb);
	}

}
