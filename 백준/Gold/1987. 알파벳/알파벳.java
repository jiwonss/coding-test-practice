import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int R, C, result;
	static int[][] board;
	static int[] visited = new int[26];
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		board = new int[R][C];
		for (int i = 0; i < R; i++) {
			String temp = br.readLine();
			for (int j = 0; j < C; j++) {
				// 해당 칸의 알파벳 아스키코드 저장
				board[i][j] = temp.charAt(j) - 'A';
			}
		}
		
		result = 0;
		dfs(0, 0, 0);
		System.out.println(result);
	}
	
	// (x, y) : 현재 칸 좌표, cnt : 말이 지나온 칸 수
	private static void dfs(int x, int y, int cnt) {
		// 새로 이동한 칸에 적혀 있는 알파벳이 이전에 방문한 알파벳인 경우
		// 말이 지날 수 있는 최대 칸의 수 갱신
		if (visited[board[x][y]] == 1) {
			result = Math.max(result, cnt);
			return;
		}
		
		// 현재 칸 방문 표시
		visited[board[x][y]] = 1;
		// 상하좌우 확인
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			// 다음 칸이 보드를 벗어나는 경우
			if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
			// 다음 칸이 보드를 벗어나지 않는 경우, 다음 칸으로 이동
			dfs(nx, ny, cnt + 1);
		}
		// 현재 칸 방문 해제
		visited[board[x][y]] = 0;
	}

}
