import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	
	static int N, maxCoreCnt, result;
	static int[][] board;
	static List<int[]> core;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			
			N = Integer.parseInt(br.readLine());
			
			board = new int[N][N];
			core = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
					if (board[i][j] == 1) {
						// 가장자리에 위치한 Core는 이미 전원이 연결되었으므로 continue
						if (i == 0 || i == N - 1 || j == 0 || j == N - 1) continue;
						core.add(new int[] {i, j});
					}
				}
			}
			
			maxCoreCnt = 0; result = Integer.MAX_VALUE;
			dfs(board, 0, 0, 0);
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}
	
	// 백트래킹
	// 최대한 많은 core를 연결하고 그 중 전선 길이의 합이 최소인 경우를 찾아야 한다.
	private static void dfs(int[][] board, int k, int coreCnt, int len) {
		// 가지치기(시간초과 해결)
		if (core.size() - k + coreCnt < maxCoreCnt) return;
		if (k == core.size()) {
			// 최대 코어 수 갱신, 전선 길이의 합을 담을 변수도 초기화해준다.
			if (maxCoreCnt < coreCnt) {
				maxCoreCnt = coreCnt;
				result = Integer.MAX_VALUE;
			}
			result = Math.min(result, len);				
			return;
		}
		
		int[] c = core.get(k);
		int x = c[0], y = c[1];

		int[][] temp = copyBoard(board);
		for (int d = 0; d < 4; d++) {
			int cnt = install(temp, x, y, d);
			if (cnt == -1)  {
				temp = copyBoard(board);
				dfs(temp, k + 1, coreCnt, len);
			} else {
				dfs(temp, k + 1, coreCnt + 1, len + cnt);					
			}
			temp = copyBoard(board);
		}
	}
	
	// 배열 복사
	private static int[][] copyBoard(int[][] board) {
		int[][] temp = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				temp[i][j] = board[i][j];
			}
		}
		return temp;
	}
	
	// core와 전원 연결하는 전선 설치
	private static int install(int[][] board, int x, int y, int d) {
		int len = 0;
		int nx, ny;
		while (true) {
			nx = x + dx[d];
			ny = y + dy[d];
			if (!isIn(nx, ny) || board[nx][ny] != 0) return -1;
			if (isEdge(nx, ny)) return len + 1;
			board[nx][ny] = 2; // 전선 설치
			x = nx; y = ny;
			len++;
		}
	}
	
	// 가장자리 확인
	private static boolean isEdge(int x, int y) {
		if (x == 0 || x == N - 1 || y == 0 || y == N - 1) return true;
		return false;
	}
	
	private static boolean isIn(int x, int y) {
		if (x < 0 || x >= N || y < 0 || y >= N) return false;
		return true;
	}
	
	
}
