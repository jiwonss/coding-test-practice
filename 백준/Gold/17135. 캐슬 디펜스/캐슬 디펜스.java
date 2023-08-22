import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, D, totalEnemyCnt, result;
	static int[] archer = new int[3]; 
	static int[][] board, copyBoard, visited;
	static int[] dx = {0, -1, 0}, dy = {-1, 0, 1};
	static List<int[]> archerList, enemyList;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		board = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 1) totalEnemyCnt++;
			}
		}
		
		result = 0;
		selectArcher(0, 0);
		System.out.println(result);
	}		
		
	// 3명의 궁수 배치
	// 궁수가 있을 수 있는 위치는 (N, 0) ~ (N, M - 1)
	private static void selectArcher(int start, int k) {
		if (k == 3) {
			archerList = new ArrayList<>();
			for (int i = 0; i < 3; i++) {
				archerList.add(new int[] {N, archer[i]});
			}
			copyBoard();
			result = Math.max(result, play(totalEnemyCnt));
			return;
		}
		
		for (int i = start; i < M; i++) {
			archer[k] = i;
			selectArcher(i + 1, k + 1);
		}
	}
	
	// 격자판 복사
	private static void copyBoard() {
		copyBoard = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				copyBoard[i][j] = board[i][j];
			}
		}
	}
	
	// 게임 진행 
	private static int play(int totalEnemyCnt) {
		int removeEnemyCnt = 0; // 궁수의 공격으로 제거되는 적의 수
		// 격자판에 존재하는 적의 수가 0이 아니면 게임 진행
		while (totalEnemyCnt > 0) {
			// 궁수가 공격할 적 찾기
			enemyList = new ArrayList<>();
			for (int i = 0; i < 3; i++) {
				int[] pos = archerList.get(i);
				visited = new int[N][M];
				bfs(pos[0], pos[1]);
			}

			// 궁수가 적 공격
			for (int i = 0; i < enemyList.size(); i++) {
				int[] pos = enemyList.get(i);
				if (copyBoard[pos[1]][pos[2]] == 0) continue;
				copyBoard[pos[1]][pos[2]] = 0;
				removeEnemyCnt++;
				totalEnemyCnt--;
			}
			
			// 공격 끝, 적 이동
			int x, y;
			for (int i = N - 1; i > -1; i--) {
				for (int j = 0; j < M; j++) {
					if (copyBoard[i][j] == 0) continue;
					x = i + 1; y = j;
					copyBoard[i][j] = 0;
					if (!isIn(x, y)) {
						totalEnemyCnt--;
						continue;
					}
					copyBoard[x][y] = 1;
				}
			}
		}
		return removeEnemyCnt;
	}

	// 궁수의 위치에서 가장 가까운 적 찾기
	private static void bfs(int i, int j) {
		// 우선순위 큐, (거리, x좌표, y좌표)
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0]) return o1[2] - o2[2];
				return o1[0] - o2[0];
			}
		});
		
		// bfs
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {i, j});
		while (!q.isEmpty()) {
			int[] pos = q.poll();
			for (int d = 0; d < 3; d++) {
				int nx = pos[0] + dx[d];
				int ny = pos[1] + dy[d];
				if (!isIn(nx, ny) || visited[nx][ny] == 1) continue;
				if (copyBoard[nx][ny] == 1) {
					int distance = getDistance(new int[] {i, j}, new int[] {nx, ny});
					if (distance > D) break;
					pq.add(new int[] {distance, nx, ny});
				} else {
					visited[nx][ny] = 1;
					q.offer(new int[] {nx, ny});
				}
			}
		}
		
		// 제일 거리가 가까우면서 왼쪽에 있는 적을 enemyList에 추가
		if (pq.size() > 0) {
			enemyList.add(pq.poll());			
		}
	}
	
	// (x, y)가 격자판 안에 있는지 확인
	private static boolean isIn(int x, int y) {
		if (x < 0|| x >= N || y < 0 || y >= M) return false;
		return true;
	}
	
	// 궁수와 적의 거리 구하기
	private static int getDistance(int[] a, int[] b) {
		return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
	}
	
}
